using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AdminWebApplication2.Models;

namespace AdminWebApplication2.Controllers
{   
    [Authorize]
    public class cutomersController : Controller
    {
        private Sep4_GroupX2Entities db = new Sep4_GroupX2Entities();

        // GET: cutomers
        public ActionResult Index()
        {
            return View(db.cutomers.ToList());
        }

        // GET: cutomers/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            cutomer cutomer = db.cutomers.Find(id);
            if (cutomer == null)
            {
                return HttpNotFound();
            }
            return View(cutomer);
        }

        // GET: cutomers/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: cutomers/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,email,password,phone_number,userame")] cutomer cutomer)
        {
            if (ModelState.IsValid)
            {
                db.cutomers.Add(cutomer);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(cutomer);
        }

        // GET: cutomers/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            cutomer cutomer = db.cutomers.Find(id);
            if (cutomer == null)
            {
                return HttpNotFound();
            }
            return View(cutomer);
        }

        // POST: cutomers/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,email,password,phone_number,userame")] cutomer cutomer)
        {
            if (ModelState.IsValid)
            {
                db.Entry(cutomer).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(cutomer);
        }

        // GET: cutomers/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            cutomer cutomer = db.cutomers.Find(id);
            if (cutomer == null)
            {
                return HttpNotFound();
            }
            return View(cutomer);
        }

        // POST: cutomers/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            cutomer cutomer = db.cutomers.Find(id);
            db.cutomers.Remove(cutomer);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
