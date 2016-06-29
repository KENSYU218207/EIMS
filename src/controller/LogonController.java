package controller;

//ログオンの際に必要な制御クラス
public class LogonController {

	// メソッド：ログオンを依頼する
	public static void sendLogon(String userid, String password) {
		// ログオン画面で入力された[社員番号・パスワード]を社員DAOに引き渡す

		// 社員オブジェクトのインスタンスを生成

		// 認証エラーの場合、ポップアップ表示
		if (dao.EmployerDao.checkPassword(userid, password) == false) {
			System.out.println("error password");
		}

		// 社員が人事である場合、追加削除変更を可能にする
		if (dao.EmployerDao.checkJinji(userid)) {
			System.out.println("you are jinji");
		}

	}

	// メソッド：ログアウトを依頼する
	public void sendLogout() {
		// ログオンしている状態のユーザが、ログアウトした場合に呼び出される

		// 社員オブジェクトの破棄

		// 検索制御（SearchController）に、検索結果の社員リストの破棄を依頼する

	}
}
