using System;
using MVCPattern.Model;

namespace MVCPattern.Controller
{
    public interface IView
    {
        void setController(Controller controller);
        void clearList();
        void addCustomer(Customer customer);
        void removeCustomer(Customer customer);
        void updateListWithCustomer(Customer customer);
        string getSelectedCustomerID();
        void setSelectedCustomer(Customer customer);
        string Name { get; set; }
        string Address { get; set; }
        string Phone { get; set; }
        string ID { get; set; }
        bool isModify { set; }
    }
}
