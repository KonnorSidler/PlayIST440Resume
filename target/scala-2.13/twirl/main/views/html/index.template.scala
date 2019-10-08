
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 """),format.raw/*10.24*/("""{"""),format.raw/*10.25*/("""font-family: "Lato", sans-serif;"""),format.raw/*10.57*/("""}"""),format.raw/*10.58*/("""
"""),format.raw/*11.1*/("""body, html """),format.raw/*11.12*/("""{"""),format.raw/*11.13*/("""
  """),format.raw/*12.3*/("""height: 100%;
  color: #777;
  line-height: 1.8;
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""

"""),format.raw/*17.1*/("""/* Create a Parallax Effect */
.bgimg-1, .bgimg-2, .bgimg-3 """),format.raw/*18.30*/("""{"""),format.raw/*18.31*/("""
  """),format.raw/*19.3*/("""background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
"""),format.raw/*23.1*/("""}"""),format.raw/*23.2*/("""

"""),format.raw/*25.1*/("""/* First image (Logo. Full height) */
.bgimg-1 """),format.raw/*26.10*/("""{"""),format.raw/*26.11*/("""
  """),format.raw/*27.3*/("""background-image: url('/w3images/parallax1.jpg');
  min-height: 100%;
"""),format.raw/*29.1*/("""}"""),format.raw/*29.2*/("""

"""),format.raw/*31.1*/("""/* Second image (Portfolio) */
.bgimg-2 """),format.raw/*32.10*/("""{"""),format.raw/*32.11*/("""
  """),format.raw/*33.3*/("""background-image: url("/w3images/parallax2.jpg");
  min-height: 400px;
"""),format.raw/*35.1*/("""}"""),format.raw/*35.2*/("""

"""),format.raw/*37.1*/("""/* Third image (Contact) */
.bgimg-3 """),format.raw/*38.10*/("""{"""),format.raw/*38.11*/("""
  """),format.raw/*39.3*/("""background-image: url("/w3images/parallax3.jpg");
  min-height: 400px;
"""),format.raw/*41.1*/("""}"""),format.raw/*41.2*/("""

"""),format.raw/*43.1*/(""".w3-wide """),format.raw/*43.10*/("""{"""),format.raw/*43.11*/("""letter-spacing: 10px;"""),format.raw/*43.32*/("""}"""),format.raw/*43.33*/("""
"""),format.raw/*44.1*/(""".w3-hover-opacity """),format.raw/*44.19*/("""{"""),format.raw/*44.20*/("""cursor: pointer;"""),format.raw/*44.36*/("""}"""),format.raw/*44.37*/("""

"""),format.raw/*46.1*/("""/* Turn off parallax scrolling for tablets and phones */

</style>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar" id="myNavbar">
    <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);" onclick="toggleFunction()" title="Toggle Navigation Menu">
      <i class="fa fa-bars"></i>
    </a>
    <a href="#home" class="w3-bar-item w3-button">HOME</a>
    <a href="#about" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> ABOUT</a>
    <a href="#portfolio" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-th"></i> PORTFOLIO</a>
    <a href="#contact" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-envelope"></i> CONTACT</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-red">
      <i class="fa fa-search"></i>
    </a>
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
    <a href="#about" class="w3-bar-item w3-button" onclick="toggleFunction()">ABOUT</a>
    <a href="#portfolio" class="w3-bar-item w3-button" onclick="toggleFunction()">PORTFOLIO</a>
    <a href="#contact" class="w3-bar-item w3-button" onclick="toggleFunction()">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button">SEARCH</a>
  </div>
</div>

<!-- First Parallax Image with Logo Text -->
<div class="bgimg-1 w3-display-container w3-opacity-min" id="home">
  <div class="w3-display-middle" style="white-space:nowrap;">
    <span class="w3-center w3-padding-large w3-black w3-xlarge w3-wide w3-animate-opacity">MY <span class="w3-hide-small">WEBSITE</span> LOGO</span>
  </div>
</div>

<!-- Container (About Section) -->
<div class="w3-content w3-container w3-padding-64" id="about">
  <h3 class="w3-center">ABOUT ME</h3>
  <p class="w3-center"><em>I love photography</em></p>
  <p>We have created a fictional "personal" website/blog, and our fictional character is a hobby photographer. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa
    qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
  <div class="w3-row">
    <div class="w3-col m6 w3-center w3-padding-large">
      <p><b><i class="fa fa-user w3-margin-right"></i>My Name</b></p><br>
      <img src="/w3images/avatar_hat.jpg" class="w3-round w3-image w3-opacity w3-hover-opacity-off" alt="Photo of Me" width="500" height="333">
    </div>

    <!-- Hide this text on small devices -->
    <div class="w3-col m6 w3-hide-small w3-padding-large">
      <p>Welcome to my website. I am lorem ipsum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
        dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
  </div>
  <p class="w3-large w3-center w3-padding-16">Im really good at:</p>
  <p class="w3-wide"><i class="fa fa-camera"></i>Photography</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:90%">90%</div>
  </div>
  <p class="w3-wide"><i class="fa fa-laptop"></i>Web Design</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:85%">85%</div>
  </div>
  <p class="w3-wide"><i class="fa fa-photo"></i>Photoshop</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:75%">75%</div>
  </div>
</div>

<div class="w3-row w3-center w3-dark-grey w3-padding-16">
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">14+</span><br>
    Partners
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">55+</span><br>
    Projects Done
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">89+</span><br>
    Happy Clients
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">150+</span><br>
    Meetings
  </div>
</div>

<!-- Second Parallax Image with Portfolio Text -->
<div class="bgimg-2 w3-display-container w3-opacity-min">
  <div class="w3-display-middle">
    <span class="w3-xxlarge w3-text-white w3-wide">PORTFOLIO</span>
  </div>
</div>

<!-- Container (Portfolio Section) -->
<div class="w3-content w3-container w3-padding-64" id="portfolio">
  <h3 class="w3-center">MY WORK</h3>
  <p class="w3-center"><em>Here are some of my latest lorem work ipsum tipsum.<br> Click on the images to make them bigger</em></p><br>

  <!-- Responsive Grid. Four columns on tablets, laptops and desktops. Will stack on mobile devices/small screens (100% width) -->
  <div class="w3-row-padding w3-center">
    <div class="w3-col m3">
      <img src="/w3images/p1.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="The mist over the mountains">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p2.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Coffee beans">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p3.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Bear closeup">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p4.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Quiet ocean">
    </div>
  </div>

  <div class="w3-row-padding w3-center w3-section">
    <div class="w3-col m3">
      <img src="/w3images/p5.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="The mist">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p6.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="My beloved typewriter">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p7.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Empty ghost train">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p8.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Sailing">
    </div>
    <button class="w3-button w3-padding-large w3-light-grey" style="margin-top:64px">LOAD MORE</button>
  </div>
</div>

<!-- Modal for full size images on click-->
<div id="modal01" class="w3-modal w3-black" onclick="this.style.display='none'">
  <span class="w3-button w3-large w3-black w3-display-topright" title="Close Modal Image"><i class="fa fa-remove"></i></span>
  <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
    <img id="img01" class="w3-image">
    <p id="caption" class="w3-opacity w3-large"></p>
  </div>
</div>

<!-- Third Parallax Image with Portfolio Text -->
<div class="bgimg-3 w3-display-container w3-opacity-min">
  <div class="w3-display-middle">
     <span class="w3-xxlarge w3-text-white w3-wide">CONTACT</span>
  </div>
</div>

<!-- Container (Contact Section) -->
<div class="w3-content w3-container w3-padding-64" id="contact">
  <h3 class="w3-center">WHERE I WORK</h3>
  <p class="w3-center"><em>I'd love your feedback!</em></p>

  <div class="w3-row w3-padding-32 w3-section">
    <div class="w3-col m4 w3-container">
      <img src="/w3images/map.jpg" class="w3-image w3-round" style="width:100%">
    </div>
    <div class="w3-col m8 w3-panel">
      <div class="w3-large w3-margin-bottom">
        <i class="fa fa-map-marker fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i> Chicago, US<br>
        <i class="fa fa-phone fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i> Phone: +00 151515<br>
      </div>
      <p>Swing by for a cup of <i class="fa fa-coffee"></i>, or leave me a note:</p>
      <form action="/action_page.php" target="_blank">
        <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
          <div class="w3-half">
            <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
          </div>
          <div class="w3-half">
            <input class="w3-input w3-border" type="text" placeholder="Email" required name="Email">
          </div>
        </div>
        <input class="w3-input w3-border" type="text" placeholder="Message" required name="Message">
        <button class="w3-button w3-black w3-right w3-section" type="submit">
          <i class="fa fa-paper-plane"></i> SEND MESSAGE
        </button>
      </form>
    </div>
  </div>
</div>

<!-- Footer -->
<footer class="w3-center w3-black w3-padding-64 w3-opacity w3-hover-opacity-off">
  <a href="#home" class="w3-button w3-light-grey"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
  <div class="w3-xlarge w3-section">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>

<script>
// Modal Image Gallery
function onClick(element) """),format.raw/*252.27*/("""{"""),format.raw/*252.28*/("""
  """),format.raw/*253.3*/("""document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
"""),format.raw/*257.1*/("""}"""),format.raw/*257.2*/("""

"""),format.raw/*259.1*/("""// Change style of navbar on scroll
window.onscroll = function() """),format.raw/*260.30*/("""{"""),format.raw/*260.31*/("""myFunction()"""),format.raw/*260.43*/("""}"""),format.raw/*260.44*/(""";
function myFunction() """),format.raw/*261.23*/("""{"""),format.raw/*261.24*/("""
    """),format.raw/*262.5*/("""var navbar = document.getElementById("myNavbar");
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) """),format.raw/*263.84*/("""{"""),format.raw/*263.85*/("""
        """),format.raw/*264.9*/("""navbar.className = "w3-bar" + " w3-card" + " w3-animate-top" + " w3-white";
    """),format.raw/*265.5*/("""}"""),format.raw/*265.6*/(""" """),format.raw/*265.7*/("""else """),format.raw/*265.12*/("""{"""),format.raw/*265.13*/("""
        """),format.raw/*266.9*/("""navbar.className = navbar.className.replace(" w3-card w3-animate-top w3-white", "");
    """),format.raw/*267.5*/("""}"""),format.raw/*267.6*/("""
"""),format.raw/*268.1*/("""}"""),format.raw/*268.2*/("""

"""),format.raw/*270.1*/("""// Used to toggle the menu on small screens when clicking on the menu button
function toggleFunction() """),format.raw/*271.27*/("""{"""),format.raw/*271.28*/("""
    """),format.raw/*272.5*/("""var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) """),format.raw/*273.47*/("""{"""),format.raw/*273.48*/("""
        """),format.raw/*274.9*/("""x.className += " w3-show";
    """),format.raw/*275.5*/("""}"""),format.raw/*275.6*/(""" """),format.raw/*275.7*/("""else """),format.raw/*275.12*/("""{"""),format.raw/*275.13*/("""
        """),format.raw/*276.9*/("""x.className = x.className.replace(" w3-show", "");
    """),format.raw/*277.5*/("""}"""),format.raw/*277.6*/("""
"""),format.raw/*278.1*/("""}"""),format.raw/*278.2*/("""
"""),format.raw/*279.1*/("""</script>

</body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-10-08T17:07:26.004
                  SOURCE: C:/Users/konno/IST Projects/IST440Resume/PlayIST440Resume/app/views/index.scala.html
                  HASH: 72f48ace3bc45516c0f8f279b3db719db1ce593e
                  MATRIX: 1030->0|1506->448|1535->449|1595->481|1624->482|1653->484|1692->495|1721->496|1752->500|1831->552|1859->553|1890->557|1979->618|2008->619|2039->623|2189->746|2217->747|2248->751|2324->799|2353->800|2384->804|2483->876|2511->877|2542->881|2611->922|2640->923|2671->927|2771->1000|2799->1001|2830->1005|2896->1043|2925->1044|2956->1048|3056->1121|3084->1122|3115->1126|3152->1135|3181->1136|3230->1157|3259->1158|3288->1160|3334->1178|3363->1179|3407->1195|3436->1196|3467->1200|13826->11530|13856->11531|13888->11535|14129->11748|14158->11749|14190->11753|14285->11819|14315->11820|14356->11832|14386->11833|14440->11858|14470->11859|14504->11865|14667->11999|14697->12000|14735->12010|14844->12091|14873->12092|14902->12093|14936->12098|14966->12099|15004->12109|15122->12199|15151->12200|15181->12202|15210->12203|15242->12207|15375->12311|15405->12312|15439->12318|15559->12409|15589->12410|15627->12420|15687->12452|15716->12453|15745->12454|15779->12459|15809->12460|15847->12470|15931->12526|15960->12527|15990->12529|16019->12530|16049->12532
                  LINES: 33->1|42->10|42->10|42->10|42->10|43->11|43->11|43->11|44->12|47->15|47->15|49->17|50->18|50->18|51->19|55->23|55->23|57->25|58->26|58->26|59->27|61->29|61->29|63->31|64->32|64->32|65->33|67->35|67->35|69->37|70->38|70->38|71->39|73->41|73->41|75->43|75->43|75->43|75->43|75->43|76->44|76->44|76->44|76->44|76->44|78->46|284->252|284->252|285->253|289->257|289->257|291->259|292->260|292->260|292->260|292->260|293->261|293->261|294->262|295->263|295->263|296->264|297->265|297->265|297->265|297->265|297->265|298->266|299->267|299->267|300->268|300->268|302->270|303->271|303->271|304->272|305->273|305->273|306->274|307->275|307->275|307->275|307->275|307->275|308->276|309->277|309->277|310->278|310->278|311->279
                  -- GENERATED --
              */
          