let curYear, curMonth;

const years = [ "2020", "2021", "2022"];
const months = [ "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
const tags = ["stateDt", "decideCnt", "deathCnt", "updateDt"];

let days = [];
let deathData = [];
let decideData = [];
function moveYear(i) {
    curYear += i;

    if(curMonth > 9 && curYear == 22) {
        curYear--;
        alert("해당 월에는 데이터가 존재하지 않습니다.");
    }
    else getData();
}
function moveMonth(i) {
    curMonth += i;
    if(curMonth <1 || curMonth > 12) {
        curYear += i;
        curMonth -= 12*i; 
    }
    getData();
}
function setButton() { 
    if(curYear == 22) {
        document.getElementById("nextYear").setAttribute("style", "color:#a39485");
        if(curMonth == 9) document.getElementById("nextMonth").setAttribute("style", "color:#a39485");
        else document.getElementById("nextMonth").setAttribute("style", "color:white");
    }
    else  {
        document.getElementById("nextYear").setAttribute("style", "color:white");
        document.getElementById("nextMonth").setAttribute("style", "color:white");
    }

    if(curYear == 20) {
        document.getElementById("previousYear").setAttribute("style", "color:#a39485") ;
        if(curMonth == 1) document.getElementById("previousMonth").setAttribute("style", "color:#a39485");
        else document.getElementById("previousMonth").setAttribute("style", "color:white");
    }
    else {
        document.getElementById("previousMonth").setAttribute("style", "color:white");
        document.getElementById("previousYear").setAttribute("style", "color:white");
    }
}
function getData() {
    setButton();
    const year = years[curYear-20];
    const month = months[curMonth - 1];
    document.getElementById("year").innerHTML = year;
    document.getElementById("month").innerHTML = month;
    const startDt = year + month + "01";
    const endDt = year + month + new Date(year, month, 0).getDate();
    
    const promise = new Promise(function(resolve, reject) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', getURL(startDt, endDt));
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                resolve(this.responseText);
            }
        };
        xhr.send('');
    }).then(function(xml) {
        let parseXML = new DOMParser();
        let result = parseXML.parseFromString(xml, "text/xml");

        const cnt = result.getElementsByTagName("totalCount")[0].innerHTML;
        const items = result.getElementsByTagName("items")[0].getElementsByTagName("item");
        
        const tableContent = document.getElementById("tableContent");

        days = [];
        decideData = [];
        deathData = [];
        tableContent.innerHTML = "";
        for(let i=0; i<cnt; i++) {
            const tr = document.createElement("tr");
            for(let j=0; j<tags.length; j++) {
                const td = document.createElement("td");

                var item = items[i].getElementsByTagName(tags[j])[0];
                if(item != null) {
                    switch(j) {
                        case 0 : 
                            days.push(item.innerHTML);
                            break;
                        case 1:
                            decideData.push(new Number(item.innerHTML));
                            break;
                        case 2:
                            deathData.push(new Number(item.innerHTML));
                            break;
                    }
                    td.innerText = item.innerHTML;
                }
                tr.appendChild(td);
            }
            tableContent.appendChild(tr);
        }
    }).then(function() {
        const parent = document.getElementById("dataChart");
        parent.innerHTML = "";
        
        var canv= document.createElement('canvas');
        canv.id = "chartContent";
        parent.appendChild(canv);

        context = canv.getContext('2d');
        context.save();
        context.setTransform(1, 0, 0, 1, 0, 0);
        context.clearRect(0, 0, canv.width, canv.height);

        context.restore();
        drawChart();
    });
}
function getURL(startDt, endDt) {
    const serviceKey = "9B3HafYmb%2FmmyP5WiO%2Bg%2B7W44uhGJlHB50EXEXRJRmr5mmCr50IFHV7iNDTtFxsiKuo0suhTvHvY3KQAoa9qeA%3D%3D";
    const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/

    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+ serviceKey; /*Service Key*/
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent(startDt); /**/
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent(endDt); /**/

    return url + queryParams;
}
function drawChart() {
    const tableContent = document.getElementById("chartContent");
    
    var chart = new Chart(tableContent, {
        type: 'line',
        data : {
            labels : days,
            datasets: [ {
                label: '확진자(누적)수',
                fill: false,
                borderColor: '#a39485',
                data : decideData,
                cubicInterpolationMode: 'monotone',
                tension: 0.4
            }, {
                label: '사망자(누적)수',
                fill: false,
                borderColor: '#73685d',
                data : deathData,
                cubicInterpolationMode: 'monotone',
                tension: 0.4
            }]
        }
    })
}