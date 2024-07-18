package Trump;
//work9_4パッケージのFantanPlayerクラスをインポート
import work9_4.FantanPlayer;

/*クラス名:FantanMaster
 *概要:七並べの進行役を管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class FantanMaster extends Master {
	//パスできる回数の上限を定数化
	public static final int PASS_LIMIT = 3;

	/*関数名:passDeclaration
	 *概要:プレイヤーのパス回数を管理
	 *引数:プレイヤー(FantanPlayerクラス)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void passDeclaration(FantanPlayer gamePlayer) {
		//プレイヤーのパス回数を表示
		System.out.println(gamePlayer + "さんは" + gamePlayer.getPass() + "回目のパスをしました");
		if (gamePlayer.getPass() > PASS_LIMIT) {
			//敗者を表示
			System.out.println("\n" + gamePlayer + "さんの負けです");
			//敗者をゲームから除外
			deregisterPlayer(gamePlayer);
		}

	}

}
