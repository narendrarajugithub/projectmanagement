
var cdata=decodeData(chartdata);
var charArray=JSON.parse(cdata);
var charLenth=charArray.length;

var numdata=[];
var labels =[];

for(var i=0;i<charLenth;i++){
	numdata[i]=charArray[i].value;
	labels[i]=charArray[i].stage;
}



var ctx = document.getElementById('Mychart').getContext('2d');
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels:labels,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: numdata
        }]
    },
    options: {
    
    	
    }
});

function decodeData(data){
var txt=	document.createElement("textarea");
	txt.innerHTML=data;
	var value_c=txt.value;
	return value_c;
}