function drawCalendar() {
    let c = getContainer();
    let days = ["일", "월", "화", "수", "목", "금", "토"];

    //월-금 라인 그리기
    for(i = 0; i<7; i++) {
        const title = document.createElement("div");
        if(i%7 ==6) title.classList.add("sat");
        if(i%7 == 0) title.classList.add("sun");
        title.classList.add("day");
        title.innerHTML = days[i];
        c.appendChild(title);
    }
    document.getElementById("calendar").appendChild(c);
    c = getContainer();
    
    //격자 그리기
    for(i = 1; i<=42; i++) {
        c.appendChild(getBox(i));
        if(i % 7 == 0)  {
            document.getElementById("calendar").appendChild(c);
            c = getContainer();
        }
    }
    var today = new Date();
    curDate = today.getDate();
    //날짜 입력하기
    setCalendarNumber();

    //현재 날짜 선택하기
    setCurDate(curDate + DAY);
}

function move(value) {
    curMonth += value;

    if(curMonth > 12) {
        curMonth = 1;
        curYear += 1;
    }
    else if(curMonth < 1) {
        curMonth = 12;
        curYear -= 1;
    }
    document.getElementById("date").innerText = (curMonth+"월, " + curYear + "년");
    
    setCurDate("");
    setCalendarNumber();
}

function addTask() {
    const todo = prompt('할 일이 무엇입니까?');
        if(todo != null) {  //리스트를 작성한 경우
            insertTask(todo);
            const id = "day" + curDate + "-" + ++taskCount;

            const content = document.getElementById("content");
            content.appendChild(getTask(id, todo));

            const box = document.getElementById("day" + (curDate + DAY));
            box.appendChild(getRound());
        }
}

function loadTasks() {
    const tasks = getAllTasks();
    const content = document.getElementById("content");

    taskCount = 0;

    if(tasks == null) return;
    for(i = 0; i < tasks.length; i++) {
        const id = "day" + curDate + "-" + ++taskCount;

        content.appendChild(getTask(id, tasks[i]));
    }
}

function deleteAllTask() {
    if(curDate == "") {
        alert("날짜를 선택해주세요.");
        return;
    }
    removeAllTask();
    
    const content = document.getElementById("content");
    content.textContent = "";

    const curBox = document.getElementById("day" + (curDate+DAY));
    for(k=0;; k++) {
        if(curBox.childNodes[1] ==null) return;
        curBox.childNodes[1].remove();
        
    }
}