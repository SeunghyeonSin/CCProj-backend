<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
var bnum = '${board.bnum}'; //게시글 번호
 
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
    commentInsert(insertData); //Insert 함수호출(아래)
});
 
 
 
//댓글 목록 
function commentList(){
    $.ajax({
        url : '/commentlist',
        type : 'get',
        data : {'bnum':bnum},
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ 
                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div class="commentInfo'+value.cnum+'">'+'댓글번호 : '+value.cnum+' / 작성자 : '+value.nickname;
                a += '<a onclick="commentUpdate('+value.cnum+',\''+value.content+'\');"> 수정 </a>';
                a += '<a onclick="commentDelete('+value.cnum+');"> 삭제 </a> </div>';
                a += '<div class="commentContent'+value.cnum+'"> <p> 내용 : '+value.content +'</p>';
                a += '</div></div>';
            });
            
            $(".commentList").html(a);
        }
    });
}
 
//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/commentinsert',
        type : 'post',
        data : insertData,
        success : function(data){
            if(data == 1) {
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val('');
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(cnum, content){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+cnum+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+cnum+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+cnum).html(a);
    
}
 
//댓글 수정
function commentUpdateProc(cnum){
    var updateContent = $('[name=content_'+cnum+']').val();
    
    $.ajax({
        url : '/commentupdate',
        type : 'post',
        data : {'content' : updateContent, 'cnum' : cnum},
        success : function(data){
            if(data == 1) commentList(bnum); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function commentDelete(cnum){
    $.ajax({
        url : '/commentdelete/'+cnum,
        type : 'post',
        success : function(data){
            if(data == 1) commentList(bnum); //댓글 삭제후 목록 출력 
        }
    });
}
 
 
 
 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});
 
 
 
</script>