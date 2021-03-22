$(function(){

    const appendTask = function(data){
        var taskCode = '<a href="#" class="task-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

    //Show adding task form
    $('#show-add-task-form').click(function(){
        $('#task-add').css('display', 'flex');
    });

    //Show updating task form
    $('#show-update-task-form').click(function(){
        $('#task-update').css('display', 'flex');
    });

    //Show deleting task form
    $('#show-delete-task-form').click(function(){
        $('#task-delete').css('display', 'flex');
    });

    //Closing adding task form
    $('#task-add').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Closing updating task form
    $('#task-update').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Closing adding task form
    $('#task-delete').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting task
    $(document).on('click', '.task-link', function(){
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/tasks/' + taskId,
            success: function(response)
            {
                var code = '<span>Дата создания:' + response.date + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Задача не найдена!');
                }
            }
        });
        return false;
    });

    //Adding task
    $('#save-task').click(function()
    {
        var data = $('#task-add form').serialize();
        $.ajax({
            method: "POST",
            url: '/tasks/',
            data: data,
            success: function(response)
            {
                $('#task-add').css('display', 'none');
                var task = {};
                task.id = response;
                var dataArray = $('#task-add form').serializeArray();
                for(i in dataArray) {
                    task[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTask(task);
            }
        });
        return false;
    });

});