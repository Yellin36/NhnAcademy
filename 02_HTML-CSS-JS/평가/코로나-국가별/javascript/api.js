const serviceKey = "9B3HafYmb%2FmmyP5WiO%2Bg%2B7W44uhGJlHB50EXEXRJRmr5mmCr50IFHV7iNDTtFxsiKuo0suhTvHvY3KQAoa9qeA%3D%3D";

let allData = [], areaData = new Map();
let curPage, curArea, curRow, curLastPage, curData;

function getData() {
    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson'; 
    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+ serviceKey;
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220930'); 
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220930'); 
    
    const primise = new Promise(function(resolve, reject) {
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                resolve(this.responseText);
            }
        };
        xhr.send('');
    }).then(function(result) {
        const parseXML = new DOMParser();
        const results = parseXML.parseFromString(result, "text/xml");
        const items = results.getElementsByTagName("item");

        for(let i=1; i<items.length; i++) {     
            var enAreaName = items[i].getElementsByTagName("areaNmEn")[0].innerHTML;   
            var koNationName = items[i].getElementsByTagName("nationNm")[0].innerHTML;      
            var enNationName = items[i].getElementsByTagName("nationNmEn")[0].innerHTML;

            var defCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;
            var deathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;
            var deathCnt = items[i].getElementsByTagName("natDeathCnt")[0].innerHTML; 
            
            if(areaData.get(enAreaName) == null) {
                areaData.set(enAreaName, []);
            }
            var nation = [enNationName, koNationName, defCnt, deathCnt, deathRate];
            
            areaData.get(enAreaName).push(nation);
            allData.push(nation);
        }
        curArea = "All";
        curRow = 10;

        setPage(curArea, curRow);
        getMap();
    });
}
function setPage(area, row) {
    curPage = 1;
    curArea = area; 
    curRow = row; 
    curData = (area == "All") ? allData : areaData.get(area);
    curLastPage = Math.ceil(curData.length / row);

    setData(curData, curPage, curRow);
    setButton(curPage, curLastPage);
}
function setData(data, page, row) {
    const tableContent = document.getElementById("tableContent");

    let start = (page - 1) * row;
    let end = start + row;
    

    if(end > data.length) end = data.length;

    tableContent.innerHTML = "";
    for(let i = start; i < end; i++) {
        const tr = document.createElement("tr");

        tr.addEventListener("click", function() {
            openWin = window.open("popup.html"+ "?name="+data[i][1], data[i][1], "resizable = no, scrolbars = yes");
        }, false);

        const num = document.createElement("td");
        num.innerHTML = i + 1;
        tr.appendChild(num);

        for(let j =1; j<allData[i].length; j++) {
            const td = document.createElement("td");
            td.innerHTML = data[i][j];
            
            tr.appendChild(td);
        }
        tableContent.appendChild(tr);
    }
}
function setButton(page, lastPage) {
    const pageContent = document.getElementById("pageContent");

    pageContent.innerHTML = "";
    for(let i = 1; i<=lastPage; i++) {
        const button = document.createElement("a");
        button.innerHTML = i;
        button.setAttribute("onclick", "clickButton(" + i + ")");

        pageContent.appendChild(button);
    }
    clickButton(page);
}
function clickButton(page) {
    const buttons = document.getElementById("pageContent").childNodes;

    const pbutton = document.getElementById("firstButton");
    const nbutton = document.getElementById("lastButton");

    pbutton.disabled = (page == 1) ? true : false;
    nbutton.disabled = (page == curLastPage) ? true : false; 

    for (const button of buttons) {
        if(button.innerText == page) { 
            button.setAttribute("style", "color:lightgray");
        } else button.setAttribute("style", "");
    }
    setData(curData, page, curRow);

    curPage = page;
}
