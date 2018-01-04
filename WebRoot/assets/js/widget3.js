
var otop = document.getElementsByClassName('zhiding')[0];
//用localStorage带来的disease参数
//console.log(localStorage.diseaseDescription);
 otop.onclick = function(){
  window.scrollTo(0,0);
 }
 //findDiseaseCategoryBySystemId.action
 var dId=window.location.href.split('=',2)[1];
 //下面打算按钮点击权限发送ajax
 $.ajax({
    url: url+'/ErXueSSM/user/findDiseaseCategoryWithAcupointsById.action',
    type: 'POST',
    dataType: '',
    data: {diseaseCategoryId: dId},
    success:function(data){
        $('.main-class').append('<p style="border: solid gray 1px" class="main-class-attention"><span class="main-class-span"><b>疾病描述:</b></span><span>'+data.diseaseDescription+'<span/></p><button class="btn am-btn-primary">查看治疗方案</button>');
        $('.btn').click(function(){
          var mod=[]; 
          var arr=[];
          var vid=[];
          var vad=[];
          // console.log(data.attention);
          $('.main-class').append('<p style="border: solid gray 1px" class="main-class-attention"><span class="main-class-span"><b>治疗方案：</b></span>'+data.attention+'</p>');
          //diseaseDescription       
        
        $('#main-title').text(data.diseaseCategoryName);
        $('.am-header-title').text(data.diseaseCategoryName);
        for(var i=0;i<data.diseaseCategoryAndAcupointList.length;i++){
          if(data.diseaseCategoryAndAcupointList[i].acupointType==='主穴'){
          mod.push(data.diseaseCategoryAndAcupointList[i].acupointName);
          vid.push(data.diseaseCategoryAndAcupointList[i].videoLocation);//vid主穴视频，vad配穴视频
          }else{
          arr.push(data.diseaseCategoryAndAcupointList[i].acupointName);
          vad.push(data.diseaseCategoryAndAcupointList[i].videoLocation);
          }//判断主配穴
        }
        $('.main-class ').append('<span><p>主穴:</p></span>');
        for (var i = 0; i < mod.length; i++) {
          $('.main-class').append('<a class="fl" href="#myvideo" name='+vid[i]+'>'+mod[i]+'</a>');
        }
        $('.main-class ').append('<span><p>配穴:</p></span>');
        for (var i = 0; i < arr.length; i++) {
          $('.main-class').append('<a class="fl" href="#myvideo" name='+vad[i]+'>'+arr[i]+'</a>');
        }
        $('.main-class').append('</br><video src='+vid[0]+'  width=300px height=200px controls="controls" id="myvideo">');
        $('.main-class a').each(function(){
          $(this).click(function(){
            let mySrc = $(this).attr('name')
            $('#myvideo').attr('src',mySrc);
            console.log($('#myvideo').attr('src'));
          });
        });
      $('.btn').css('display', 'none');
      });
    }
  });

