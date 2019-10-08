
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">

<head>
    <title>"""),_display_(/*13.13*/title),format.raw/*13.18*/("""</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href='"""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.97*/("""'>
    <link rel="stylesheet" media="screen" href='"""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/prism.css")),format.raw/*16.98*/("""'>
    <link rel="shortcut icon" type="image/png" href='"""),_display_(/*17.55*/routes/*17.61*/.Assets.versioned("images/favicon.png")),format.raw/*17.100*/("""'>
    <script src='"""),_display_(/*18.19*/routes/*18.25*/.Assets.versioned("javascripts/hello.js")),format.raw/*18.66*/("""' type="text/javascript"></script>
    <script src='"""),_display_(/*19.19*/routes/*19.25*/.Assets.versioned("javascripts/prism.js")),format.raw/*19.66*/("""' type="text/javascript"></script>
</head>

<body>
    <section id="top">
        <div class="wrapper">
            <img class="resize" src="assets/images/play_icon_reverse.svg" alt="logo" />
            <h1>Play Hello World Web Tutorial</h1>
        </div>
    </section>
    """),_display_(/*29.6*/content),format.raw/*29.13*/("""
"""),format.raw/*30.1*/("""</body>

</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-10-08T17:07:26.046
                  SOURCE: C:/Users/konno/IST Projects/IST440Resume/PlayIST440Resume/app/views/main.scala.html
                  HASH: 415d1df2d47ec34c6bb9259d8f3c59f1bbddbdfb
                  MATRIX: 1211->266|1336->296|1366->300|1450->357|1476->362|1638->497|1653->503|1715->544|1795->597|1810->603|1873->645|1958->703|1973->709|2034->748|2083->770|2098->776|2160->817|2241->871|2256->877|2318->918|2632->1206|2660->1213|2689->1215
                  LINES: 33->7|38->7|40->9|44->13|44->13|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|60->29|60->29|61->30
                  -- GENERATED --
              */
          