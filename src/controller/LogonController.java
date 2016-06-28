package controller;

public class LogonController {

	// ログオンを依頼する	認証エラーはポップアップ表示
	public static  void sendLogon(String userid, String password) {

		if(dao.EmployerDao.checkPassword(userid, password) == false){
			//ポップアップ表示
			System.out.println("error password");
		}

		if(dao.EmployerDao.checkJinji(userid)){
			//追加、削除可能にする
			System.out.println("you are jinji");
		}

	}

	// ログアウトを依頼する
	public void sendLogout() {


	}


	// 社員オブジェクトの破棄を依頼する
	public void sendEmployee() {

	}
}
