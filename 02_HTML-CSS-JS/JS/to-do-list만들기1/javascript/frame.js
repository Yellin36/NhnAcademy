function getContainer() {
    const container = document.createElement("div");
    container.classList.add("container");
    
    return container;
}
function getBox(id) {
    const dayBox = document.createElement("div");
    dayBox.id = "day" + id;
    dayBox.classList.add("box");

    if(id % 7 == 0) dayBox.classList.add("sat");
    if(id % 7 == 1) dayBox.classList.add("sun");

    dayBox.addEventListener("click", function(){
        setCurDate(id);
    }, false);
    
    return dayBox;
}
function getRound() {
    const round = document.createElement("div");
    round.classList.add("round");

    return round;
}

function getTask(id, content) {
    const line = document.createElement("div");

    line.innerHTML = " □ " + content;
    // const task = document.createElement("input");
    // task.type = "checkbox";
    // task.value = content;
    // line.appendChild(task);

    line.id = id;
    line.classList.add("task");
    line.addEventListener("click", function() {
        event.stopPropagation();
        if(confirm('삭제하시겠습니까?') == true) {
            line.remove();
            removeTask(content);
        }
    });
    return line;
}