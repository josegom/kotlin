package org.jetbrains.kotlin.demo

//gradle tomcatRunWar

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import com.github.kittinunf.fuel.httpGet


@WebServlet(name = "Hello", value = "/hello")
class HomeController : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {

        val host = req.getParameter("url")
        val password = req.getParameter("pass")

        val auth = hashMapOf("Authorization" to "Basic ${password}")

        val (request, response, result) ="https://${host}/rest/api/latest/issue/AG-141".httpGet().header(auth).responseString()
        res.writer.write(result.get())
    }
}

