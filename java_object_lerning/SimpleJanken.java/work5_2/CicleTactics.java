package work5_2;


/*クラス名:CicleTactics
 *概要:ジャンケンの手を戦略的に管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class CicleTactics implements Tactics {
	//プレイヤーの手グーを定数化
	public static final int HAND_STONE = 0;
	//プレイヤーの手チョキを定数化
	public static final int HAND_SCISSORS = 1;
	//プレイヤーの手パーを定数化
	public static final int HAND_PAPER = 2;
	//プレイヤーの最初の手をグーで初期化
	private int tacticsCount = HAND_STONE;

	/*関数名:readTactics
	 *概要:グーチョキパーの順にジャンケンの手を出す
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int readTactics() {
		//パーを出した次がグーを出す処理
		tacticsCount = tacticsCount > HAND_PAPER ? HAND_STONE: tacticsCount;
		//プレイヤーの手を格納する変数グーチョキパーを順番に代入
		int playerHand = tacticsCount;
		//次ぎだす手を決定
		tacticsCount++;
		//プレイヤーの手を返却
		return playerHand;
	}

}
