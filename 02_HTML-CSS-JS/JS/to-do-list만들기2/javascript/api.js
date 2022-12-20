const userId="yerin";

async function getEvents(targetDate) {
    const promise = new Promise(function(resolve, reject) {
        const xhr = new XMLHttpRequest();
        const url = `http://133.186.211.156:8100/api/${userId}/calendars/day/${targetDate}`;

        xhr.open('GET', url);
        xhr.onreadystatechange = function() {
            if(this.readyState == 4) {
                resolve(this.responseText);
            }
        }
        xhr.send('');
    }).then(function(items) {
        const result = JSON.parse(items);
        const contentBox = document.getElementById("content");

        for(let i = 0; i < result.length; i++) {
            const id = result[i].id;
            const subject = result[i].subject;
            contentBox.appendChild(getTask(id, subject));
        }
    }).catch(e=>{
        console.log("error:",e);
    }).finally((arr)=>{
    });
}

function getAllEvent(targetMonth) {
    const url = `http://133.186.211.156:8100/api/${userId}/calendars/month/${targetMonth}`;
    const option = {
        method : "GET"
    }
    fetch(url, option)
        .then(function(response) {
            return response.json();
        }).then(function(result) {
            for(let i=0; i<result.length; i++) {
                const day = new String(result[i].eventDt);
                let id = new Number(day.substr(8));
                
                const dayBox = document.getElementById("day" + (id+DAY));
                dayBox.appendChild(getRound());
            }
        })

}
function deleteEvent(taskId) {
    const url = `http://133.186.211.156:8100/api/${userId}/calendars/events/${taskId}`
    const option = {
        method : "DELETE"
    }
    fetch(url, option);
}
async function deleteAllEvent(targetMonth, targetDate) {
    const url1 = `http://133.186.211.156:8100/api/${userId}/calendars/day/${targetDate}`;
    
    const option = {
        method : "GET"
    }
    fetch(url1, option)
    .then(function(response) {
        console.log(response);
        return response.json();
    }).then(function(result) {
        for(let i =0; i<result.length; i++) {
            console.log(result[i]);
            deleteEvent(result[i]);
        }
    });
    // for(let i =0; i<arr.length; i++) {
    //     deleteEvent(arr[i]);
    // }
    // fetch(url1, option)
    //     .then(function(response) {
    //         console.log(response,"헟ㄹ");
    //         return response.json();
    //     }).then(function(result) {
    //         console.log(result);
    //         let arrs = [];
    //         for(let i=0; i<result.length; i++) {
    //             const id = new String(result[i].id);
    //             result[]
    //             if()
    //             deleteEvent(id);
    //         }
    //     });
        location.reload();
}
function saveEvent(subject) {
    if(curDate == "") {
        alert("날짜를 선택해 주세요!");
        return;
    }
    const promise = new Promise(function(resolve, reject){
        const xhr = new XMLHttpRequest();
        const url = `http://133.186.211.156:8100/api/${userId}/calendars/events`;
        
        xhr.open('POST', url);
        xhr.setRequestHeader("Content-Type",'application/json');

        const data = {
            "subject" : subject,
            "eventDt" : getKey(getCurDate())
        }
        
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                resolve(this.responseText);
            }
        };

        xhr.send(JSON.stringify(data));
    }).then(function(jsonString){
        result = JSON.parse(jsonString);
        alert("등록완료!");
        
        location.reload();
    });
}