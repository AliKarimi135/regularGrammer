/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTools;

/**
 * this package:a)فرم برنامه را در وسط صفحه مانیتور کاربر نشان می دهد.<br>
 *              b)برای بررسی رشته است که رشته مورد نظر الفبا کوچک باشد
 */
public class CheckInput {

    /**
     * this function: بررسی می کند که رشته ورودی اش الفبا کوچک باشد
     * @param inputStr ورودی تابع
     * @return true || false
     */
    public boolean CheckAlephba(String inputStr) {
        inputStr = inputStr.trim();
        char[] s = inputStr.toCharArray();
        for (int j = 0; j < s.length; j++) {
            if (!(s[j] >= 'a' && s[j] <= 'z')) {
                return false;
            }
        }

        return true;
    }
}
