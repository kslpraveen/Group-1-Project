package duplicate;//####[1]####
//####[1]####
import java.io.File;//####[2]####
//####[2]####
//-- ParaTask related imports//####[2]####
import pt.runtime.*;//####[2]####
import java.util.concurrent.ExecutionException;//####[2]####
import java.util.concurrent.locks.*;//####[2]####
import java.lang.reflect.*;//####[2]####
import pt.runtime.GuiThread;//####[2]####
import java.util.concurrent.BlockingQueue;//####[2]####
import java.util.ArrayList;//####[2]####
import java.util.List;//####[2]####
//####[2]####
public class Parallel {//####[3]####
    static{ParaTask.init();}//####[3]####
    /*  ParaTask helper method to access private/protected slots *///####[3]####
    public void __pt__accessPrivateSlot(Method m, Object instance, TaskID arg, Object interResult ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {//####[3]####
        if (m.getParameterTypes().length == 0)//####[3]####
            m.invoke(instance);//####[3]####
        else if ((m.getParameterTypes().length == 1))//####[3]####
            m.invoke(instance, arg);//####[3]####
        else //####[3]####
            m.invoke(instance, arg, interResult);//####[3]####
    }//####[3]####
//####[4]####
    File file;//####[4]####
//####[5]####
    String name;//####[5]####
//####[5]####
    String title;//####[5]####
//####[6]####
    int size;//####[6]####
//####[7]####
    long start, end;//####[7]####
//####[8]####
    public Parallel(File file, String name, String title, int size) {//####[8]####
        this.file = file;//####[9]####
        this.name = name;//####[10]####
        this.title = title;//####[11]####
        this.size = size;//####[12]####
    }//####[14]####
//####[15]####
    public void startRunning() {//####[15]####
        TaskInfo __pt__id = new TaskInfo();//####[16]####
//####[16]####
        boolean isEDT = GuiThread.isEventDispatchThread();//####[16]####
//####[16]####
//####[16]####
        /*  -- ParaTask notify clause for 'id' -- *///####[16]####
        try {//####[16]####
            Method __pt__id_slot_0 = null;//####[16]####
            __pt__id_slot_0 = ParaTaskHelper.getDeclaredMethod(getClass(), "finishedBuilding", new Class[] {});//####[16]####
            if (false) finishedBuilding(); //-- ParaTask uses this dummy statement to ensure the slot exists (otherwise Java compiler will complain)//####[16]####
            __pt__id.addSlotToNotify(new Slot(__pt__id_slot_0, this, false));//####[16]####
//####[16]####
        } catch(Exception __pt__e) { //####[16]####
            System.err.println("Problem registering method in clause:");//####[16]####
            __pt__e.printStackTrace();//####[16]####
        }//####[16]####
        TaskID id = runPSNM(__pt__id);//####[16]####
    }//####[17]####
//####[18]####
    private static volatile Method __pt__runPSNM__method = null;//####[18]####
    private synchronized static void __pt__runPSNM__ensureMethodVarSet() {//####[18]####
        if (__pt__runPSNM__method == null) {//####[18]####
            try {//####[18]####
                __pt__runPSNM__method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__runPSNM", new Class[] {//####[18]####
                    //####[18]####
                });//####[18]####
            } catch (Exception e) {//####[18]####
                e.printStackTrace();//####[18]####
            }//####[18]####
        }//####[18]####
    }//####[18]####
    public TaskID<Void> runPSNM() {//####[18]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[18]####
        return runPSNM(new TaskInfo());//####[18]####
    }//####[18]####
    public TaskID<Void> runPSNM(TaskInfo taskinfo) {//####[18]####
        // ensure Method variable is set//####[18]####
        if (__pt__runPSNM__method == null) {//####[18]####
            __pt__runPSNM__ensureMethodVarSet();//####[18]####
        }//####[18]####
        taskinfo.setParameters();//####[18]####
        taskinfo.setMethod(__pt__runPSNM__method);//####[18]####
        taskinfo.setInstance(this);//####[18]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[18]####
    }//####[18]####
    public void __pt__runPSNM() {//####[18]####
        TaskID psnm = psnm();//####[19]####
        TaskInfo __pt__view = new TaskInfo();//####[21]####
//####[21]####
        /*  -- ParaTask dependsOn clause for 'view' -- *///####[21]####
        __pt__view.addDependsOn(psnm);//####[21]####
//####[21]####
        TaskID view = showDuplicate(__pt__view);//####[21]####
        try {//####[23]####
            view.waitTillFinished();//####[24]####
        } catch (Exception e) {//####[26]####
            e.printStackTrace();//####[27]####
        }//####[28]####
    }//####[29]####
//####[29]####
//####[30]####
    private static volatile Method __pt__psnm__method = null;//####[30]####
    private synchronized static void __pt__psnm__ensureMethodVarSet() {//####[30]####
        if (__pt__psnm__method == null) {//####[30]####
            try {//####[30]####
                __pt__psnm__method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__psnm", new Class[] {//####[30]####
                    //####[30]####
                });//####[30]####
            } catch (Exception e) {//####[30]####
                e.printStackTrace();//####[30]####
            }//####[30]####
        }//####[30]####
    }//####[30]####
    public TaskID<Void> psnm() {//####[30]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[30]####
        return psnm(new TaskInfo());//####[30]####
    }//####[30]####
    public TaskID<Void> psnm(TaskInfo taskinfo) {//####[30]####
        // ensure Method variable is set//####[30]####
        if (__pt__psnm__method == null) {//####[30]####
            __pt__psnm__ensureMethodVarSet();//####[30]####
        }//####[30]####
        taskinfo.setParameters();//####[30]####
        taskinfo.setMethod(__pt__psnm__method);//####[30]####
        taskinfo.setInstance(this);//####[30]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[30]####
    }//####[30]####
    public void __pt__psnm() {//####[30]####
        start = System.currentTimeMillis();//####[31]####
        if (name.equals("dblp.xml")) //####[32]####
        {//####[32]####
            PSNM.psnmDBLP(file, title, size);//####[33]####
        }//####[34]####
        if (name.equals("cd.csv")) //####[35]####
        {//####[35]####
            PSNM.psnmCD(file, title, size);//####[36]####
        }//####[37]####
        end = System.currentTimeMillis();//####[38]####
    }//####[39]####
//####[39]####
//####[40]####
    private static volatile Method __pt__showDuplicate__method = null;//####[40]####
    private synchronized static void __pt__showDuplicate__ensureMethodVarSet() {//####[40]####
        if (__pt__showDuplicate__method == null) {//####[40]####
            try {//####[40]####
                __pt__showDuplicate__method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__showDuplicate", new Class[] {//####[40]####
                    //####[40]####
                });//####[40]####
            } catch (Exception e) {//####[40]####
                e.printStackTrace();//####[40]####
            }//####[40]####
        }//####[40]####
    }//####[40]####
    public TaskID<Void> showDuplicate() {//####[40]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[40]####
        return showDuplicate(new TaskInfo());//####[40]####
    }//####[40]####
    public TaskID<Void> showDuplicate(TaskInfo taskinfo) {//####[40]####
        // ensure Method variable is set//####[40]####
        if (__pt__showDuplicate__method == null) {//####[40]####
            __pt__showDuplicate__ensureMethodVarSet();//####[40]####
        }//####[40]####
        taskinfo.setParameters();//####[40]####
        taskinfo.setMethod(__pt__showDuplicate__method);//####[40]####
        taskinfo.setInstance(this);//####[40]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[40]####
    }//####[40]####
    public void __pt__showDuplicate() {//####[40]####
        ArrayList<String> dup = new ArrayList<String>(PSNM.duplicates);//####[41]####
        ViewDuplicate vd = new ViewDuplicate("PSNM");//####[42]####
        vd.setVisible(true);//####[43]####
        vd.setSize(600, 400);//####[44]####
        vd.viewDup(dup);//####[45]####
    }//####[46]####
//####[46]####
//####[47]####
    private void finishedBuilding() {//####[47]####
        System.out.println("over");//####[48]####
		MainScreen.propose_time = end-start;
        System.out.println("Total Parallel Processing Time " + (end - start));//####[49]####
    }//####[50]####
}//####[50]####
