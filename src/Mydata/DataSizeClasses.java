/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mydata;

import java.util.ArrayList;

/**
 *
 *
 * for    one) به دست آوردن تعداد متغیرهای گرامر<br>
 *        two)به دست آوردن تعداد الفباهای گرامر<br>
 *       three)به دست آوردن متغیر های گرامر<br>
 *        four)به دست آوردن الفباهای های گرامر<br>
 *        five) برای کپی کردن لیستی به لیست دیگر<br>
 */
public class DataSizeClasses {

    int numberVarible = 0, numberAlephba = 0;
    String varible1, varible2;
    /**
     * this function jobs:به دست آوردن تعداد متغیرهای گرامر
     */
    String strNull = "#";

    public int getNumberOfVarible(ArrayList<GrammerProperties> list) {
        for (int k = 0; k < list.size(); k++) {
            varible1 = list.get(k).getLeftValue();
            varible2 = list.get(k).getRightValue();
            if (varible1.compareTo(strNull) != 0) {
                numberVarible++;
            }

            if (varible2.compareTo(strNull) != 0 && varible2.compareTo("@") != 0) {
                numberVarible++;
            }

            if (varible1.compareTo(strNull) != 0 && varible2.compareTo(strNull) != 0) {
                if (varible1.compareTo(varible2) == 0) {
                    numberVarible--;
                }
            }

            list.get(k).setLeftValue(strNull);
            list.get(k).setRightValue(strNull);
            for (int j = k + 1; j < list.size(); j++) {

                if (varible1.compareTo(list.get(j).getLeftValue()) == 0) {
                    list.get(j).setLeftValue(strNull);
                }
                if (varible1.compareTo(list.get(j).getRightValue()) == 0) {
                    list.get(j).setRightValue(strNull);
                }

                if (varible2.compareTo(list.get(j).getLeftValue()) == 0) {
                    list.get(j).setLeftValue(strNull);
                }
                if (varible2.compareTo(list.get(j).getRightValue()) == 0) {
                    list.get(j).setRightValue(strNull);
                }
            }//end for2
        }//end for 1
        System.out.println("numberOfVar=" + numberVarible);
        return numberVarible;
    }
    //*********************************

    /**
     * this function jobs is:به دست آوردن متغیر های گرامر
     * @param list
     * @param vars
     */
    public void getResiveVarible(ArrayList<GrammerProperties> list, String[] vars) {
        int cv = 0;
        for (int k = 0; k < list.size(); k++) {
            varible1 = list.get(k).getLeftValue();
            varible2 = list.get(k).getRightValue();
            if (varible1.compareTo(strNull) != 0) {
                vars[cv] = varible1;
                cv++;
            }
            if (varible2.compareTo(strNull) != 0 && varible2.compareTo("@") != 0) {
                vars[cv] = varible2;
                cv++;
            }
            if (varible1.compareTo(strNull) != 0 && varible2.compareTo(strNull) != 0) {
                if (varible1.compareTo(varible2) == 0) {
                    cv--;
                }
            }
            list.get(k).setLeftValue(strNull);
            list.get(k).setRightValue(strNull);
            for (int j = k + 1; j < list.size(); j++) {

                if (varible1.compareTo(list.get(j).getLeftValue()) == 0) {
                    list.get(j).setLeftValue(strNull);
                }
                if (varible1.compareTo(list.get(j).getRightValue()) == 0) {
                    list.get(j).setRightValue(strNull);
                }

                if (varible2.compareTo(list.get(j).getLeftValue()) == 0) {
                    list.get(j).setLeftValue(strNull);
                }
                if (varible2.compareTo(list.get(j).getRightValue()) == 0) {
                    list.get(j).setRightValue(strNull);
                }
            }//end for2
        }//end for 1
        for (int j = 0; j < numberVarible; j++) {
            System.out.println("varible[" + j + "]=" + vars[j]);
        }
    }

    /**
     * this function jobs:به دست آوردن تعداد الفباهای گرامر
     * @param list
     * @return الفباهای گرامر
     */
    public int getNumberOfAlephba(ArrayList<GrammerProperties> list) {
        for (int k = 0; k < list.size(); k++) {
            varible1 = list.get(k).getAlephba();
            if (varible1.compareTo(strNull) != 0) {
                numberAlephba++;
                for (int j = k + 1; j < list.size(); j++) {
                    varible2 = list.get(j).getAlephba();
                    if (varible1.compareTo(varible2) == 0) {
                        list.get(j).setAlephba(strNull);
                    }
                }
            }
        }//end for

        System.out.println("\nnumberaleph= " + numberAlephba);
        return numberAlephba;
    }

    /**
     * this function jobs:به دست آوردن الفباهای های گرامر
     * @param list
     * @param alephba
     */
    public void getResiveAlephba(ArrayList<GrammerProperties> list, String[] alephba) {
        int ca = 0;
        for (int k = 0; k < list.size(); k++) {
            varible1 = list.get(k).getAlephba();
            if (varible1.compareTo(strNull) != 0) {
                alephba[ca] = varible1;
                ca++;

                for (int j = k + 1; j < list.size(); j++) {
                    varible2 = list.get(j).getAlephba();
                    if (varible1.compareTo(varible2) == 0) {
                        list.get(j).setAlephba(strNull);
                    }
                }
            }
        }//end for
    }

    /**
     * this function jobs is:copy list1 to list2
     * @param list1
     * @param list2
     */
    public void copyToList(ArrayList<GrammerProperties> list1, ArrayList<GrammerProperties> list2) {
        GrammerProperties Gm;
        for (int j = 0; j < list1.size(); j++) {
            Gm = new Mydata.GrammerProperties();
            Gm.setLeftValue(list1.get(j).getLeftValue());
            Gm.setAlephba(list1.get(j).getAlephba());
            Gm.setRightValue(list1.get(j).getRightValue());
            list2.add(j, Gm);
        }
    }

    /**
     * jobs:بررسی می کند که آیا حالت مورد نظر در آرایه حالات نهایی است؟
     * @param stateFinal آرایه ایی از حالات نهایی
     * @param nextState یک حالت از حالات گرامر
     * @return true if nextState in stateFina array
     */
    public boolean isFinal(String[] stateFinal, String nextState) {

        String[] StFinal = stateFinal;
        for (int j = 0; j < StFinal.length; j++) {
            if (StFinal[j].compareTo(nextState) == 0) {
                return true;
            }
        }
        if (nextState.compareTo("@") == 0) {
            return true;
        }
        return false;
    }
}
