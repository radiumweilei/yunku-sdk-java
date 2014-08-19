import Model.BaseData;
import com.yunkuent.sdk.DebugConfig;
import com.yunkuent.sdk.EntFileManager;
import com.yunkuent.sdk.EntLibManager;
import com.yunkuent.sdk.EntManager;
import com.yunkuent.sdk.data.ReturnResult;
import com.yunkuent.sdk.utils.Util;
import org.apache.http.HttpStatus;

/**
 * Created by Brandon on 2014/8/6.
 */
public class SDKTester {
    public static final String UESRNAME = "gktest";
    public static final String PASSWORD = "111111";
    public static final String CLIENT_ID = "b2b54fa4261f9cf5e4772e6359f96161";
    public static final String CLIENT_SECRET = "134dba8e0adc4e59b511c09aa1ebf71e";


    private static EntLibManager mEntLibManger;
    private static EntManager mEntManger;
    private static EntFileManager mFileManager;

    public static void main(String[] args) {
        DebugConfig.PRINT_LOG = true;
//        DebugConfig.LOG_PATH="D://LogPath";//默认在D盘根目录

        //==========================云库企业库操作==========================//
        mEntLibManger = new EntLibManager(UESRNAME, PASSWORD, CLIENT_ID, CLIENT_SECRET);
//        //获取认证
        mEntLibManger.accessToken(true);
        //创建云库
//        deserializeReturn(mEntLibManger.create("city2", 10, "city2", "test lib"));
        //获取库列表
//        deserializeReturn(mEntLibManger.getLibList());
        //获取库授权
//        deserializeReturn(mEntLibManger.bind(21340,"",""));
        //取消库授权
//        deserializeReturn(mEntLibManger.unBind("0b7bd4e22c1a9eb8e3ddba2b6c37f6e2"));

        //添加库成员
//        deserializeReturn(mEntLibManger.addMembers(150998,2892,new int[]{4}));
        //获取某一个库的成员
//        deserializeReturn(mEntLibManger.getMembers(0, 2, 32662));

        //批量修改单库中成员角色
//        deserializeReturn(mEntLibManger.setMemberRole(150998,2894,new int[]{4}));

        //从库中删除成员
//        deserializeReturn(mEntLibManger.delMember(150998,new int[]{4}));

        //获取某一个企业分组列表
//        deserializeReturn(mEntLibManger.getGroups(32657));

        //库上添加分组
//        deserializeReturn(mEntLibManger.addGroup(150998,4448,2892));
        //库上删除分组
//        deserializeReturn(mEntLibManger.delGroup(150998,4448));
        //设置分组上的角色
//        deserializeReturn(mEntLibManger.setGroupRole(150998,4448,2894));

//=======文件操作========//

        String orgClientId = "bab623c8a80283689c6a77fec0ecede1";
        String orgClientSecret = "fd5ba40932fa31dd18170881b9f00e77";
        mFileManager=new EntFileManager(orgClientId,orgClientSecret);
        //获取库中文件
//        deserializeReturn(mFileManager.getFileList((int)Util.getUnixDateline(), 0, ""));

        //获取更新列表
//        deserializeReturn(mFileManager.getUpdateList((int) Util.getUnixDateline(), false, 0));

        //获取文件(夹)信息
//        deserializeReturn(mFileManager.getFileInfo((int) Util.getUnixDateline(),"test"));

        //创建文件夹
//        deserializeReturn(mFileManager.createFolder((int) Util.getUnixDateline(),"test","Brandon"));

        //上传文件 文件不得超过50MB
//        deserializeReturn(mFileManager.createFile((int) Util.getUnixDateline(),"test/test.txt","Brandon","D:\\test.txt"));

        //删除文件
//        deserializeReturn(mFileManager.del((int) Util.getUnixDateline(),"test","Brandon"));

        //移动文件
//        deserializeReturn(mFileManager.move((int) Util.getUnixDateline(),"test/test.txt","test.txt","Brandon"));

        //文件连接
//        deserializeReturn(mFileManager.link( (int) Util.getUnixDateline(), "test.txt"));

        //发送消息
//        deserializeReturn(mFileManager.sendmsg( (int) Util.getUnixDateline(), "msgTest", "msg", "", "", "Brandon"));

        //获取当前库所有外链(new)
//        deserializeReturn(mFileManager.links((int) Util.getUnixDateline()));


//==========================云库企业操作==========================//
        mEntManger = new EntManager(UESRNAME, PASSWORD, CLIENT_ID, CLIENT_SECRET);
        //获取认证k
        mEntManger.accessToken(true);
          //获取角色
//        deserializeReturn(mEntManger.getRoles());
           //获取分组
//        deserializeReturn(mEntManger.getGroups());
        //获取成员
//        deserializeReturn(mEntManger.getMembers(0, 2));

        //根据成员id获取成员个人库外链(new)
//        deserializeReturn(mEntManger.getMemberFileLink(52));
        //根据外部成员id获取成员信息(new)
//        deserializeReturn(mEntManger.getMemberByOutid(new String[]{"nishuonishuo","dqwdqw"}));
    }

    /**
     * 解析返回内容
     *
     * @param result
     */
    private static void deserializeReturn(String result) {

        //解析结果
        ReturnResult returnResult = ReturnResult.create(result);

        if (returnResult.getStatusCode() == HttpStatus.SC_OK) {
            //成功的结果
            System.out.println("return 200");

        } else {
            //解析result中的内容
            BaseData data = BaseData.create(returnResult.getResult());
            if (data != null) {
                //如果可解析，则返回错误信息和错误号
                System.out.println(data.getErrorCode() + ":" + data.getErrorMsg());
            }
        }
        System.out.println(returnResult.getResult());
        //复制到剪贴板
        Util.copyToClipboard(returnResult.getResult());
    }


}

