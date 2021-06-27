using System;
using System.Collections;
using MVCPattern.Model;

namespace MVCPattern.Controller
{
    public class Controller
    {
        IView _view = null;
        IList _customers = null;
        Customer _selectedCustomer;

        public Controller(IView view, IList customers)
        {
            _view = view;
            _customers = customers;
            view.setController(this);
        }
        
        private void updateView(Customer customer)
        {
            _view.ID = customer.ID;
            _view.Name = customer.Name;
            _view.Phone = customer.Phone;
            _view.Address = customer.Address;
        }

        private void updateCustomer(Customer customer)
        {
            customer.ID = _view.ID;
            customer.Name = _view.Name;
            customer.Phone = _view.Phone;
            customer.Address = _view.Address;
        }

        public void LoadView()
        {
            _view.clearList();
            foreach (Customer customer in _customers)
                _view.addCustomer(customer);

            _view.setSelectedCustomer((Customer)_customers[0]);
        }

        public void SelectedCustomer(string selectedCustomerId)
        {
            foreach (Customer customer in this._customers)
            {
                if (customer.ID == selectedCustomerId)
                {
                    _selectedCustomer = customer;
                    updateView(customer);
                    _view.setSelectedCustomer(customer);
                    this._view.isModify = false;
                    break;
                }
            }
        }
        public void AddNewCustomer()
        {
            _selectedCustomer = new Customer("", "", "", "");
            updateView(_selectedCustomer);
            _view.isModify = true;
        }

        public void RemoveCustomer()
        {
            string id = this._view.getSelectedCustomerID();
            Customer customerToRemove = null;

            if (id != "")
            {
                foreach (Customer customer in _customers)
                {
                    if (customer.ID == id)
                    {
                        customerToRemove = customer;
                        break;
                    }
                }

                if (customerToRemove != null)
                {
                    int index = _customers.IndexOf(customerToRemove);
                    _customers.Remove(customerToRemove);
                    _view.removeCustomer(customerToRemove);

                    if (index > -1 && index < _customers.Count)
                    {
                        _view.setSelectedCustomer((Customer)_customers[index]);
                    }
                }
            }
        }

        public void Register()
        {
            updateCustomer(_selectedCustomer);
            if (!_customers.Contains(_selectedCustomer))
            {
                _customers.Add(_selectedCustomer);
                _view.addCustomer(_selectedCustomer);
            }
            else
            {
                _view.updateListWithCustomer(_selectedCustomer);
            }
            _view.setSelectedCustomer(_selectedCustomer);
            _view.isModify = false;
        }
    }
}
