using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MVCPattern.Controller;
using MVCPattern.Model;

namespace MVCPattern.View
{
    public partial class MainForm : Form, IView
    {
        MVCPattern.Controller.Controller _controller;
        public MainForm()
        {
            InitializeComponent();
        }
        public void setController(MVCPattern.Controller.Controller controller)
        {
            _controller = controller;
        }

        public void clearList()
        {
            listViewCustomer.Columns.Clear();
            listViewCustomer.Columns.Add("Id", 30, HorizontalAlignment.Left);
            listViewCustomer.Columns.Add("Name", 50, HorizontalAlignment.Left);
            listViewCustomer.Columns.Add("Phone", 100, HorizontalAlignment.Left);
            listViewCustomer.Columns.Add("Address", 100, HorizontalAlignment.Left);
            listViewCustomer.Items.Clear();
        }

        public void addCustomer(Customer customer)
        {
            ListViewItem parent;
            parent = listViewCustomer.Items.Add(customer.ID);
            parent.SubItems.Add(customer.Name);
            parent.SubItems.Add(customer.Phone);
            parent.SubItems.Add(customer.Address);
        }

        public void updateListWithCustomer(Customer customer)
        {
            ListViewItem item = null;

            foreach (ListViewItem row in listViewCustomer.Items)
            {
                if (row.Text == customer.ID)
                    item = row;
            }

            if (item != null)
            {
                item.Text = customer.ID;
                item.SubItems[1].Text = customer.Name;
                item.SubItems[2].Text = customer.Phone;
                item.SubItems[3].Text = customer.Address;
            }
        }

        public void removeCustomer(Customer customer)
        {

            ListViewItem item = null;

            foreach (ListViewItem row in listViewCustomer.Items)
            {
                if (row.Text == customer.ID)
                    item = row;
            }

            if (item != null)
            {
                listViewCustomer.Items.Remove(item);
                listViewCustomer.Focus();
            }
        }

        public string getSelectedCustomerID()
        {
            if (listViewCustomer.SelectedItems.Count > 0)
                return listViewCustomer.SelectedItems[0].Text;
            else
                return "";
        }

        public void setSelectedCustomer(Customer customer)
        {
            foreach (ListViewItem row in listViewCustomer.Items)
            {
                if (row.Text == customer.ID)
                    row.Selected = true;
                else
                    row.Selected = false;
            }
        }

        public string ID
        {
            get { return textBoxID.Text; }
            set { textBoxID.Text = value; }
        }

        public string Name
        {
            get { return textBoxName.Text; }
            set { textBoxName.Text = value; }
        }

        public string Phone
        {
            get { return textBoxPhone.Text; }
            set { textBoxPhone.Text = value; }
        }
        public string Address
        {
            get { return textBoxAddress.Text; }
            set { textBoxAddress.Text = value; }
        }

        public bool isModify
        {
            set { textBoxID.Enabled = value; }
        }
        
        private void buttonRemoveCustomer_Click(object sender, EventArgs e)
        {
            _controller.RemoveCustomer();
        }

        private void buttonRegister_Click(object sender, EventArgs e)
        {
            _controller.Register();
        }

        private void listViewCustomer_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listViewCustomer.SelectedItems.Count > 0)
                _controller.SelectedCustomer(listViewCustomer.SelectedItems[0].Text);
        }

        private void buttonNewCustomer_Click(object sender, EventArgs e)
        {
            _controller.AddNewCustomer();
        }
    }
}
