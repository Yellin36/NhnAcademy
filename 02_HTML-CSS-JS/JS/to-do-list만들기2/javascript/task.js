function getKey(date) {
    let month = getCurMonth();
    if(month < 10 ) month = "0" + month;

    if(date < 10) date = "0" + date;
    return getCurYear() + "-" + month + "-" + date;
}
function getMonthKey() {
    let month = getCurMonth();
    if(month < 10 ) month = "0" + month;

    return getCurYear() + "-" + month;
}
function addTask() {
    const todo = prompt('할 일이 무엇입니까?');
    if(todo != null) {  //리스트를 작성한 경우
        saveEvent(todo);
    }
}

function loadTasks() {
    if(getCurDate() != "") getEvents(getKey(getCurDate()));
}

function loadRounds() {
    getAllEvent(getMonthKey());
}

