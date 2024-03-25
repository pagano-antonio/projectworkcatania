<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Girlz</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<style>

*{
  margin: 0;
  padding: 0;
  text-decoration: none;
}
:root {
  --accent-color: #fff;
  --gradient-color: #FBFBFB;
}

body,
html {
    width: 100%;
    height: 100vh;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

body{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100vw;background: linear-gradient(90deg, #C7C5F4, #776BCC);
  height: 100vh;
  background-image: linear-gradient(-45deg, #e3eefe 0%, #efddfb 100%);
  &::after {
        content:"";
        display: block;
        width: 100%;
        height: 125vh;
        position: absolute;
        z-index: -1;
        transform: rotate(20deg);
        border-radius: 50%;
    }
}

.wordCarousel {
    font-size: 56px;
    font-weight: 80;
    color: #a759f5;
    div {
        overflow: hidden;
        position: relative;
        float: right;
        height:70px;
        padding-top: 10px;
        margin-top: -10px;
        li {
            font-family: Lato, sans-serif;
            color: #a759f5;
            font-weight: 700;
            padding: 0 10px;
            height: 45px;
            margin-bottom: 45px;
            display: block;
        }
    }
}

.flip2 { animation: flip2 6s cubic-bezier(0.23, 1, 0.32, 1.2) infinite; }
.flip3 { animation: flip3 8s cubic-bezier(0.23, 1, 0.32, 1.2) infinite; }
.flip4 { animation: flip4 10s cubic-bezier(0.23, 1, 0.32, 1.2) infinite; }
.flip5 { animation: flip5 12s cubic-bezier(0.23, 1, 0.32, 1.2) infinite; }

@keyframes flip2 {
    0% { margin-top: -180px; }
    5% { margin-top: -90px;  }
    50% { margin-top: -90px; }
    55% { margin-top: 0px; }
    99.99% { margin-top: 0px; }
    100% { margin-top: -180px; }
}

@keyframes flip3 {
    0% { margin-top: -270px; }
    5% { margin-top: -180px; }
    33% { margin-top: -180px; }
    38% { margin-top: -90px; }
    66% { margin-top: -90px; }
    71% { margin-top: 0px; }
    99.99% { margin-top: 0px; }
    100% { margin-top: -270px; }
}

@keyframes flip4 {
    0% { margin-top: -360px; }
    5% { margin-top: -270px; }
    25% { margin-top: -270px; }
    30% { margin-top: -180px; }
    50% { margin-top: -180px; }
    55% { margin-top: -90px; }
    75% { margin-top: -90px; }
    80% { margin-top: 0px; }
    99.99% { margin-top: 0px; }
    100% { margin-top: -360px; }
}

@keyframes flip5 {
    0% { margin-top: -450px; }
    5% { margin-top: -360px; }
    20% { margin-top: -360px; }
    25% { margin-top: -270px; }
    40% { margin-top: -270px; }
    45% { margin-top: -180px; }
    60% { margin-top: -180px; }
    65% { margin-top: -90px; }
    80% { margin-top: -90px; }
    85% { margin-top: 0px; }
    99.99% { margin-top: 0px; }
    100% { margin-top: -450px; }
}

.sidebar{
  position: fixed;
  width: 240px;
  left: -240px;
  height: 100%;
  background-color: #fff;
  transition: all .5s ease;
}
.sidebar header{
  font-size: 28px;
  color: #353535;
  line-height: 70px;
  text-align: center;
  background-color: #fff;
  user-select: none;
  font-family: 'Lato', sans-serif;
}
.sidebar a{
  display: block;
  height: 65px;
  width: 100%;
  color: #353535;
  line-height: 65px;
  padding-left: 30px;
  box-sizing: border-box;
  border-left: 5px solid transparent;
  font-family: 'Lato', sans-serif;
  transition: all .5s ease;
}
a.active,a:hover{
  border-left: 5px solid var(--accent-color);
  color: #fff;
   background: linear-gradient(to left, var(--accent-color), var(--gradient-color));
}
.sidebar a i{
  font-size: 23px;
  margin-right: 16px;
}
.sidebar a span{
  letter-spacing: 1px;
  text-transform: uppercase;
}
#check{
  display: none;
}
label #btn,label #cancel{
  position: absolute;
  top: 15px;
  left: 15px;
  cursor: pointer;
  color: #d6adff;
  border-radius: 5px;
  margin: 15px 30px;
  font-size: 29px;
  background-color: #e8d1ff;
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
    inset -7px -7px 10px 0px rgba(0,0,0,.1),
   3.5px 3.5px 20px 0px rgba(0,0,0,.1),
   2px 2px 5px 0px rgba(0,0,0,.1);
  height: 45px;
  width: 45px;
  text-align: center;
  text-shadow: 2px 2px 3px rgba(255,255,255,0.5);
  line-height: 45px;
  transition: all .5s ease;
}
label #cancel{
  opacity: 0;
  visibility: hidden;
}
#check:checked ~ .sidebar{
  left: 0;
  
}
#check:checked ~ label #btn{
  margin-left: 245px;
  opacity: 0;
  visibility: hidden;
}
#check:checked ~ label #cancel{
  margin-left: 245px;
  opacity: 1;
  visibility: visible;
}
@media(max-width : 860px){
  .sidebar{
    height: auto;
    width: 70px;
    left: 0;
    margin: 100px 0;
  }
  header,#btn,#cancel{
    display: none;
    
  }
  span{
    position: absolute;
    margin-left: 23px;
    opacity: 0;
    visibility: hidden;
  }
  .sidebar a{
    height: 60px;
  }
  .sidebar a i{
    margin-left: -10px;
  }
  a:hover {
    width: 200px;
    background: inherit;
  }
  .sidebar a:hover span{
    opacity: 1;
    visibility: visible;
  }
}

.sidebar > a.active,.sidebar > a:hover:nth-child(even) {
  --accent-color: #52d6f4;
  --gradient-color: #c1b1f7;
}
.sidebar a.active,.sidebar > a:hover:nth-child(odd) {
  --accent-color: #c1b1f7;
  --gradient-color: #A890FE;
}


.frame {
  width: 50%;
  height: 30%;
  margin: auto;
  text-align: center;
}

h2 {
  position: relative;
  text-align: center;
  color: #353535;
  font-size: 60px;
  font-family: 'Lato', sans-serif;
  margin: 0;
  color: #a759f5;
}

p {
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  text-align: center;
  font-size: 30px;
  color: #d6adff;
  margin: 0;
}

/*immagini con paragrafo*/


@import url("https://fonts.googleapis.com/css2?family=Ubuntu+Mono&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  min-height: 100vh;
  display: grid;
  place-items: center;
  background: trasparent;
  font-family: Lato, sans serif;
  font-weight: 400;
}

.container {
  width: 100%;
  display: flex;
  justify-content: center;
  height: 500px;
  gap: 10px;

  > div {
    flex: 0 0 120px;
    border-radius: 0.5rem;
    transition: 0.5s ease-in-out;
    cursor: pointer;
    box-shadow: 1px 5px 15px #1e0e3e;
    position: relative;
    overflow: hidden;
    
    &:nth-of-type(1){
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1221744183908372550/io.jpg?ex=6613b0f0&is=66013bf0&hm=4a10bc7c682c9f9288e447f4a9045e9147ef8fa6d63245ee04cd4baa375c5fa5&")
        no-repeat 50% / cover;
    }
    &:nth-of-type(2) {
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1220327113282949120/sara.jpg?ex=660e8930&is=65fc1430&hm=93ad526109f1346760c6e75ad7f0e66826d962fc078137ff020c7cc62c7166c2&")
        no-repeat 50% / cover;
    }
    &:nth-of-type(3) {
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1220327032341266504/rosalia.jpg?ex=660e891d&is=65fc141d&hm=3af71e3ab0fe687657c743fb63dcff435fc9b4a6cf7d345089e82ac4bb6bd12a&")
        no-repeat 50% / cover;
    }
    &:nth-of-type(4) {
      background: url("https://images-ext-1.discordapp.net/external/UTbvbCRav8jZxqQIFBrZWsNmgZtHcxGFIefd2SC2ZQw/%3F_nc_cat%3D105%26ccb%3D1-7%26_nc_sid%3D5f2048%26_nc_ohc%3D9sH3yvB2m3gAX8yUOIE%26_nc_ht%3Dscontent.ftrn2-1.fna%26oh%3D00_AfDbg2qoPHaeXbX0RPe9YKUwHnE7D3HEcn9dmkg53yRaLQ%26oe%3D66008D17/https/scontent.ftrn2-1.fna.fbcdn.net/v/t39.30808-6/431580642_3675155536058619_359748094546057708_n.jpg?format=webp&width=267&height=662")
        no-repeat 50% / cover;
    }
     &:nth-of-type(5) {
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1220327147152084992/wendy.jpg?ex=660e8938&is=65fc1438&hm=a00681f84e9fc6f3f63915ad5c7f70eab4d00bca082187e59724204e3b56b2c2&")
        no-repeat 50% / cover;
    }
    &:nth-of-type(6) {
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1220327077396615188/mino.jpg?ex=660e8927&is=65fc1427&hm=064a19b0053d04ed48b33110fc518cb5170bab9a1386d22031983a6fbcc0b22f&")
        no-repeat 50% / cover;
    }
    &:nth-of-type(7) {
      background: url("https://cdn.discordapp.com/attachments/1184836800758431836/1220328936710340638/ramon.jpg?ex=660e8ae3&is=65fc15e3&hm=75824c8828157ee9524dcab2ce6b02a336c8fa9bcd2cf7e77f32c5cee3950960&")
        no-repeat 50% / cover;
    }

    .content {
      font-size: 1.5rem;
      color: #fff;
      display: flex;
      align-items: center;
      padding: 15px;
      opacity: 0;
      flex-direction: column;
      height: 100%;
      justify-content: flex-end;
      background: rgb(2, 2, 46);
      background: linear-gradient(
        0deg,
        rgba(2, 2, 46, 0.6755077030812324) 0%,
        rgba(255, 255, 255, 0) 100%
      );
      transform: translatey(100%);
      transition: opacity 0.5s ease-in-out, transform 0.5s 0.2s;
      visibility: hidden;

      span {
        display: block;
        margin-top: 5px;
        font-size: 1.2rem;
      }
    }

    &:hover {
      flex: 0 0 250px;
      box-shadow: 1px 3px 15px #7645d8;
      transform: translatey(-30px);
    }

    &:hover .content {
      opacity: 1;
      transform: translatey(0%);
      visibility: visible;
    }
  }
}

/*Animated text h2*/
.title-word {
    animation: color-animation 4s linear infinite;
    
  }
  
  .title-word-1 {
    --color-1: #DF8453;
    --color-2: #3D8DAE;
    --color-3: #E4A9A8;
  }
  
  .title-word-2 {
    --color-1: #DBAD4A;
    --color-2: #ACCFCB;
    --color-3: #17494D;
  }
  
  .title-word-3 {
    --color-1: #ACCFCB;
    --color-2: #E4A9A8;
    --color-3: #ACCFCB;
  }
  
  .title-word-4 {
    --color-1: #3D8DAE;
    --color-2: #DF8453;
    --color-3: #E4A9A8;
  }
  
  @keyframes color-animation {
    0%    {color: var(--color-1)}
    32%   {color: var(--color-1)}
    33%   {color: var(--color-2)}
    65%   {color: var(--color-2)}
    66%   {color: var(--color-3)}
    99%   {color: var(--color-3)}
    100%  {color: var(--color-1)}
  }


</style>
</head>
<body>

<body>
    <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>
    <div class="sidebar">
      <header>Menu</header>
      <a href="${pageContext.request.contextPath}/home"target="_blank">
        <i class="fas fa-qrcode"></i>
        <span>Home Page</span>
      </a>
      <a href="${pageContext.request.contextPath}/preSignUp"target="_blank">
        <i class="fas fa-user-plus"></i>
        <span>Sign Up</span>
      </a>
      <a href="${pageContext.request.contextPath}/login"target="_blank">
        <i class="fas fa-user"></i>
        <span>Login</span>
      </a>
      <a href="${pageContext.request.contextPath}/preCandidatePage"target="_blank">
        <i class="fas fa-briefcase"></i>
        <span>Candidate</span>
      </a>
      <a href="${pageContext.request.contextPath}/preJobOfferPage"target="_blank">
         <i class="fas fa-clipboard-list"></i>
        <span>Job Offers</span>
      </a>
      <a href="${pageContext.request.contextPath}/preCompaniesPage"target="_blank">
        <i class="fas fa-building"></i>
        <span>Companies</span>
      </a>
      
    </div>
</body>
    
 <p> Our Java</p>  
 
 <h2 class="title">
      <span class="title-word title-word-1">GI</span>
      <span class="title-word title-word-2">R</span>
      <span class="title-word title-word-3">L</span>
      <span class="title-word title-word-4">Z</span>
    </h2>  <p>team <p>


<div class="container">
  <div>
    <div class="content">
      <h2>Valentina La Rocca</h2>
      <span>Back End & Front End Dev</span>
    </div>
  </div>
  <div>
    <div class="content">
      <h2>Sara Brambilla</h2>
      <span>Back End & Front End Dev</span>
    </div>
  </div>
  <div>
    <div class="content">
      <h2>Rosalia Acanfora</h2>
      <span>Scrum Master</span>
    </div>
  </div>
  <div>
    <div class="content">
      <h2>Semsi Dogan</h2>
      <span>Back End Dev</span>
    </div>
  </div>
  <div>
   <div class="content">
      <h2>Wendy Sheme</h2>
      <span>Back End Dev & Designer</span>
      </div>
    </div>
    <div>
   <div class="content">
      <h2>Mino Lo Stupidino</h2>
      <span>Mascotte</span>
      </div>
    </div>
    <div>
    <div class="content">
      <h2>Ramon Il Figon</h2>
      <span>Mascotte</span>
      </div>
    </div>
    </div>
 
   
	

</body>
</html>