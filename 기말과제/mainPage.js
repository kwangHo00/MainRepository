//rollingbanner control
document.addEventListener('DOMContentLoaded', ()=>{
    var interval = window.setInterval(rollingCallback, 4000);
})
function rollingCallback(){
    document.querySelector('.rollingBanner .prev').classList.remove('prev');

    let current = document.querySelector('.rollingBanner .current');
    current.classList.remove('current');
    current.classList.add('prev');

    let next = document.querySelector('.rollingBanner .next');
    if(next.nextElementSibling == null){
        document.querySelector('.rollingBanner ul li:first-child').classList.add('next');
    }else{
        next.nextElementSibling.classList.add('next');
    }
    next.classList.remove('next');
    next.classList.add('current');
}


$(document).ready(function(){
    //page_home 스크롤 이벤트로 검색 아이콘 띄우기
    $(window).scroll(function () {
        var height = $(document).scrollTop();
        if(height < 330){
            $('.headerIconContainer .fa-magnifying-glass').hide();
        }else{
            $('.headerIconContainer .fa-magnifying-glass').fadeIn();
        }
    });

    //page_home footer 홈 버튼을 누르면 맨 위로 이동
    $('.footerHomeBtn').click(function(){
        location.href = '#home';
    })

    //page_jejuMap 제주 지도 지역 변경을 제어
    var selectedLocationVal = '구좌';
    var localName = '구좌';
    $('.page_home .locsSelectContainer span').text(localName);
    $(".locationSelector").change(function(){
        // Value값 가져오기
        selectedLocationVal = $(".locationSelector :selected").val();
        localName = $(".locationSelector :selected").text();
        if(selectedLocationVal == '구좌'){
            $('.구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_구좌').attr('fill', 'black');
        }
        else if(selectedLocationVal == '조천'){
            $('.구분_구좌, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_조천').attr('fill', 'black');
        }
        else if(selectedLocationVal == '제주시'){
            $('.구분_구좌, .구분_조천, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_제주시').attr('fill', 'black');
        }
        else if(selectedLocationVal == '애월'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_애월').attr('fill', 'black');
        }
        else if(selectedLocationVal == '한림'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_한림').attr('fill', 'black');
        }
        else if(selectedLocationVal == '한경'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_한경').attr('fill', 'black');
        }
        else if(selectedLocationVal == '대정'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_대정').attr('fill', 'black');
        }
        else if(selectedLocationVal == '안덕'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_안덕').attr('fill', 'black');
        }
        else if(selectedLocationVal == '중문'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_서귀포_남원, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_중문').attr('fill', 'black');
        }
        else if(selectedLocationVal == '서귀포_남원'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_표선, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_서귀포_남원').attr('fill', 'black');
        }
        else if(selectedLocationVal == '표선'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_성산, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_표선').attr('fill', 'black');
        }
        else if(selectedLocationVal == '성산'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_우도').attr('fill', '#CCCCCC');
            $('.구분_성산').attr('fill', 'black');
        }
        else if(selectedLocationVal == '우도'){
            $('.구분_구좌, .구분_조천, .구분_제주시, .구분_애월, .구분_한림, .구분_한경, .구분_대정, .구분_안덕, .구분_중문, .구분_서귀포_남원, .구분_표선, .구분_성산').attr('fill', '#CCCCCC');
            $('.구분_우도').attr('fill', 'black');
        }
        $('.page_home .locsSelectContainer span').text(localName);
    });
})