let DAY = new Number();
let taskCount = 0;

function setCurYear(year)   { sessionStorage.setItem("year", year); }
function getCurYear()       { return new Number(sessionStorage.getItem("year")); }
function setCurMonth(month) { sessionStorage.setItem("month", month); }
function getCurMonth()      { return new Number(sessionStorage.getItem("month")); }
function setCurDate(date)   { sessionStorage.setItem("date", date); }
function getCurDate()       { return new Number(sessionStorage.getItem("date")); }
function setLastDate(lastDate) { sessionStorage.setItem("lastDate", lastDate); }
function getLastDate()      { return new Number(sessionStorage.getItem("lastDate")); }

function setCalendarDate() { 
    const now = new Date();

    setCurYear(now.getFullYear());
    setCurMonth(now.getMonth() + 1);

    document.getElementById("date").innerText = (getCurMonth()+"월, " + getCurYear() + "년");
}

function setCalendarNumber() {   
    const lastDate = new Date(getCurYear(), getCurMonth(), 0).getDate();
    setLastDate(lastDate); 

    DAY = new Date(getCurYear(), getCurMonth() - 1, 1).getDay();

    for(i = 1; i<=42; i++) {
        const num = (i <= DAY || i > DAY + lastDate) ? "" : i - DAY;
        document.getElementById("day" + i).innerHTML = num;
    }
    //getMonthlyTask();
    loadRounds();
}

