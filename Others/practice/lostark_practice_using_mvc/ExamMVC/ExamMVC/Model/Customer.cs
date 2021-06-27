using System;

namespace MVCPattern.Model
{
    public class Customer
    {
        public Customer(string id, string name, string phone, string address)
        {
            _id = id;
            _name = name;
            _phone = phone;
            _address = address;
        }
        string _id;
        public string ID
        {
            get { return _id; }
            set { _id = value; }
        }
        string _name;
        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
        string _phone;
        public string Phone
        {
            get { return _phone; }
            set { _phone = value; }
        }
        string _address;
        public string Address
        {
            get { return _address; }
            set { _address = value; }
        }
    }
}
