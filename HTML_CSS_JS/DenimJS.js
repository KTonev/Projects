function imgSlider(input){
    document.querySelector('.jeans').src = input;
}


function desSlider(){
  var desText = document.getElementById("card_article");
  var matText = document.getElementById("card_article2");
  var dimText = document.getElementById("card_article3");
  
  matText.style.display = "none";
  desText.style.display = "inline";
  dimText.style.display = "none";
}

function desSlider2(){
  var desText = document.getElementById("card_article");
  var matText = document.getElementById("card_article2");
  var dimText = document.getElementById("card_article3");
  
  matText.style.display = "inline";
  desText.style.display = "none";
  dimText.style.display = "none";
}

function desSlider3(){
  var desText = document.getElementById("card_article");
  var matText = document.getElementById("card_article2");
  var dimText = document.getElementById("card_article3");
  
  matText.style.display = "none";
  desText.style.display = "none";
  dimText.style.display = "inline";
}



function myFunction() {
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("read_button");
  
    if (dots.style.display === "none") {
      dots.style.display = "inline";
      btnText.innerHTML = "Read more";
      moreText.style.display = "none";
    } else {
      dots.style.display = "none";
      btnText.innerHTML = "Read less";
      moreText.style.display = "inline";
    }
  }



  function myFunction2() {
    var sectionInfo = document.getElementById("info1");
    var sectionInfo2 = document.getElementById("info3");
    if (sectionInfo.style.display === "none") {
      sectionInfo.style.display = "flex";
      sectionInfo2.style.display = "flex";
    } else {
      sectionInfo.style.display = "none";
      sectionInfo2.style.display = "none";
    }
  }

