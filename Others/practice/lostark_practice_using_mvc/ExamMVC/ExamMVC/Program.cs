using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;
using MVCPattern.Model;
using MVCPattern.View;
using MVCPattern.Controller;

namespace ExamMVC
{
    static class Program
    {
        /// <summary>
        /// 해당 애플리케이션의 주 진입점입니다.
        /// </summary>
        [STAThread]
        static void Main()
        {
            MainForm form = new MainForm();

            // Add some dummy data
            IList users = new ArrayList();
            users.Add(new Customer("1", "김철수", "010-1234-5678", "서울시 강동구"));
            users.Add(new Customer("2", "이수지", "010-0000-1111", "서울시 강남구"));
            users.Add(new Customer("3", "최수정", "010-2222-3333", "서울시 강서구"));
            users.Add(new Customer("4", "박재수", "010-4444-5555", "서울시 강북구"));

            Controller controller = new Controller(form, users);
            controller.LoadView();
            form.ShowDialog();
        }
    }
}
