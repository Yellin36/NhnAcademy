function getKey() {
    return curYear + "-" + curMonth + "-" + curDate;
}
function getSomeKey(date) {
    return curYear + "-" + curMonth + "-" + date;
}
function getMonthlyKey() {
    return curYear + "-" +curMonth;
}
function insertTask(value) {
    const key = getKey();
    let values = JSON.parse(localStorage.getItem(key));

    if(values == null) values = [];
    values.push(value);
    localStorage.setItem(key, JSON.stringify(values));

    const tmpKey = getMonthlyKey();
    let days = JSON.parse(localStorage.getItem(tmpKey));
    if(days == null) days = [];
    else if(days.includes(curDate)) {
        return;
    }
    console.log(days, curDate);
    days.push(curDate);
    localStorage.setItem(tmpKey, JSON.stringify(days));
}
function removeTask(value) {
    const key = getKey();

    let values = JSON.parse(localStorage.getItem(key));
    let filteredValues = values.filter((element) => element != value);
    
    localStorage.setItem(key, JSON.stringify(filteredValues));

    const box = document.getElementById("day"+(curDate+DAY));
    box.childNodes[1].remove();
}

function removeAllTask() {  
    localStorage.removeItem(getKey()); 
}
function getAllTasks() {
    return JSON.parse(localStorage.getItem(getKey()));
}
function getMonthlyTask() {
    const tasks = JSON.parse(localStorage.getItem(getMonthlyKey()));
    
    if(tasks == null) return;
    for(var ii = 0; ii < tasks.length; ii++) {
        const box = document.getElementById("day" + (tasks[ii] + DAY));
        const task = JSON.parse(localStorage.getItem(getSomeKey(tasks[ii])));
        
        for(j =0 ; j < task.length; j++)
            box.appendChild(getRound());
    }
}
