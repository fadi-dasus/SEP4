using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using AdminWebApplication2.Models;
using System.Web.Security;

namespace AdminWebApplication2.Models
{
    public class AccountController : Controller
    {
        // GET: Account
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(admin admin)
        {
            Sep4_GroupX2Entities db = new Sep4_GroupX2Entities();
            var count = db.admins.Where(x => admin.userame == x.userame && admin.password == x.password).Count();
            if (count == 0)
            {
                ViewBag.Msg = "Invalid User";
            }
            else
            {
                FormsAuthentication.SetAuthCookie(admin.userame, false);
                return RedirectToAction("Index", "Home");
            }

            return View();
        }

        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Home");
        }
    }
}