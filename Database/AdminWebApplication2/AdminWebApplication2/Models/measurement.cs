//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace AdminWebApplication2.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class measurement
    {
        public int id { get; set; }
        public Nullable<int> co2_id { get; set; }
        public Nullable<int> humidity_id { get; set; }
        public Nullable<int> room_id { get; set; }
        public Nullable<int> temperature_id { get; set; }
    
        public virtual co2 co2 { get; set; }
        public virtual humidity humidity { get; set; }
        public virtual room room { get; set; }
        public virtual temperature temperature { get; set; }
    }
}