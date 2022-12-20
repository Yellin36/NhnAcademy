const serviceKey = "9B3HafYmb%2FmmyP5WiO%2Bg%2B7W44uhGJlHB50EXEXRJRmr5mmCr50IFHV7iNDTtFxsiKuo0suhTvHvY3KQAoa9qeA%3D%3D";
let nationName;

function getData() {
    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson'; 
    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+ serviceKey;
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220901'); 
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220930'); 
    
    const primise = new Promise(function(resolve, reject) {
        const name = document.getElementById("nationName");

        nationName = (new URL(document.location)).searchParams.get('name');
        name.innerHTML = nationName;

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

        const tags = [ "stdDay", "natDefCnt", "natDeathRate", "natDeathCnt"];
        for(let i=1; i<items.length; i++) { 
            var koNationName = items[i].getElementsByTagName("nationNm")[0].innerHTML; 

            if(koNationName == nationName) {
                const tableContent = document.getElementById("tableContent");
                const tr = document.createElement("tr");
                
                for(let j=0; j<tags.length; j++) {
                    const td = document.createElement("td");
                    td.innerHTML = items[i].getElementsByTagName(tags[j])[0].innerHTML;
                    tr.appendChild(td);
                }
                tableContent.appendChild(tr);
            }    
        }
    });
}