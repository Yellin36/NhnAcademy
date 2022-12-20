let allData;
let curPage, totalPageCnt, totalCnt;

function getCurPage() { return curPage; }
function setAllData(data) { allData = data;}
function getAllData() { return allData; }

function getDataByRegion() {
    var xhr = new XMLHttpRequest();

    const serviceKey = "9B3HafYmb%2FmmyP5WiO%2Bg%2B7W44uhGJlHB50EXEXRJRmr5mmCr50IFHV7iNDTtFxsiKuo0suhTvHvY3KQAoa9qeA%3D%3D";
    const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson';
    
    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+ serviceKey; 
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); 
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); 
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220901'); 
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220930'); 
    
    const promise = new Promise(function(resolve, reject) {
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                resolve(this.responseText);
            }
        };
        xhr.send('');
    }).then(function(result) {
        //데이터 파싱
        const praseXML = new DOMParser();
        const results = praseXML.parseFromString(result, "text/xml");
        const items = results.getElementsByTagName("items")[0].getElementsByTagName("item");
        
        let cities = new Map();
        for(let i=0; i<items.length; i++) {
            var cityName = items[i].getElementsByTagName("gubun")[0].innerHTML;
            var stdDate = items[i].getElementsByTagName("stdDay")[0].innerHTML;
            var count = items[i].getElementsByTagName("defCnt")[0].innerHTML;

            if(cities.get(cityName) == null) cities.set(cityName, [0]);
            else cities.get(cityName).push({stdDate, count});

            cities.get(cityName)[0] += new Number(count);
        }
        cities.delete("검역");
        cities.delete("합계");
        
        setAllData(cities);

        //버튼 로딩
        totalCnt = Array.from(cities.keys()).length;
        const totalPage = Math.ceil(totalCnt / 8);

        const pageContent = document.getElementById("pageContent");
        for (let i = 1; i <= totalPage; i++) {
            const button = getButton(i);
            pageContent.appendChild(button);
        }
        //데이터 로딩
        movePage(1, totalPageCnt = totalPage);
    });
}
function movePage(page) {
    const pbutton = document.getElementById("previousButton");
    const nbutton = document.getElementById("nextButton");

    pbutton.disabled = (page == 1) ? true : false;
    nbutton.disabled = (page == totalPageCnt) ? true : false;
    
    const buttons = document.getElementById("pageContent").childNodes;
    for (const button of buttons) {
        if(button.innerText == page) { 
            button.setAttribute("style", "color:white");
        } else button.setAttribute("style", "");
    }
    curPage = page;
    paging(page);
}
function paging(page, row = 8) {
    const tableContent = document.getElementById("tableContent");

    const start = (page - 1) * row;
    const keys =  Array.from(getAllData().keys());
    
    tableContent.innerHTML = "";
    for(let j = start; j < start + row; j++) {
        if(j == totalCnt) break;
        const tr = document.createElement("tr");

        const tdNum = document.createElement("td");
        tdNum.innerText = j + 1;

        const tdName = document.createElement("td");
        const name = document.createElement("a");

        name.innerText = keys[j];
        name.target = "_black";
        name.addEventListener("click", function() {
            openWindow(keys[j]);
        }, false);
        tdName.appendChild(name);
        
    
        const tdCount = document.createElement("td");
        tdCount.innerText = getAllData().get(keys[j])[0];

        tr.appendChild(tdNum);
        tr.appendChild(tdName);
        tr.appendChild(tdCount);


        tableContent.appendChild(tr);
    }  
}
// let openWin;
// const channel = new BroadcastChannel("my-channel");

// function openPage(name) {
//     channel.postMessage("");
//     sendMessage(name);
//     openWindow(name);
// }
function openWindow(name) {    
    openWin = window.open("popup.html"+ "?name="+name, name, "width=570, resizable = no, scrolbars = yes");
}

// function sendMessage(name) {
//     channel.postMessage(getAllData().get(name));
// }

function getButton(num) {
    const button = document.createElement("a");
    button.setAttribute("onclick", "movePage(" + num + ", " + totalPageCnt + ")");
    button.innerHTML = num;

    return button;
}