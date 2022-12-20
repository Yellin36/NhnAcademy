// const channel = new BroadcastChannel("my-channel");
// channel.addEventListener("message", e=> {
//     if(e=="") return;
//     console.log(e);
//     setTimeout(drawTable(e.data), 100);
// })
let pageName;
function setName() {
    const name = document.getElementById("regionName");
    let regionName = (new URL(document.location)).searchParams.get('name');
    pageName = regionName;
    name.innerHTML = regionName;
}
function setData() {
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
        
        let data = [];
        for(let i=0; i<items.length; i++) {
            var cityName = items[i].getElementsByTagName("gubun")[0].innerHTML;
            
            if(cityName != pageName) continue;

            var stdDate = items[i].getElementsByTagName("stdDay")[0].innerHTML;
            var count = items[i].getElementsByTagName("defCnt")[0].innerHTML;

            data.push({stdDate, count});
        }    
        console.log(data);
        return data;    
    }).then(function(data) {
        drawTable(data);
    });
}
function drawTable(data) {
    const tbody = document.getElementById("acontent");

    for(let i=1; i<data.length; i++) {
        const tr = document.createElement("tr");
        const td1 = document.createElement("td");
        const td2 = document.createElement("tD");

        td1.innerText = data[i].stdDate;
        td2.innerText = data[i].count;
        
        tr.appendChild(td1);
        tr.appendChild(td2);

        tbody.appendChild(tr);
    }
}