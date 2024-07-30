package work3_2;

/*クラス名:Player
 *概要:ジャンケンプレイヤーを管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class Player {

	//プレイヤーの手グーを定数化
	public static final int HAND_STONE = 1;
	//プレイヤーの手チョキを定数化
	public static final int HAND_SCISSORS = 2;
	//プレイヤーの手パーを定数化
	public static final int HAND_PAPER = 3;
	//じゃんけんの手の種類を定数化
	public static final int HAND_RANGE = 3;
	//ランダムな小数がグーの場合の範囲を定数化
	public static final int STONE_RANGE = 1;
	//ランダムな小数がチョキの場合の範囲を定数化
	public static final int SCISSORS_RANGE = 2;
	//ランダムな小数がパーの場合の範囲を定数化
	public static final int PAPER_RANGE = 3;
	
	//プレイヤーの名前のフィールドを宣言
	private String playerName;
	//勝利回数のフィールドを初期化して宣言
	private int winCount = 0;

	public Player(String playerName) {
		//名前を借り引数で初期化
		this.playerName = playerName;
	}

	/*関数名:showHand
	 *概要:ジャンケンの手をランダムに決定
	 *引数:なし
	 *戻り値:ジャンケンの手(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int showHand() {
		//じゃんけんの手を格納する変数を初期化して宣言
		double randomNumber = 0;
		//プレイヤーの手を格納する変数を初期化して宣言
		int playerHand = 0;
		//プレイヤーの手をランダムに決定
		randomNumber = Math.random() * HAND_RANGE;
		//ランダムな手がグーの場合
		if (randomNumber < STONE_RANGE) {
			//プレイヤーの手にグーを代入
			playerHand = HAND_STONE;
		}
		//ランダムな手がチョキの場合
		else if (randomNumber < SCISSORS_RANGE) {
			//プレイヤーの手にチョキを代入
			playerHand = HAND_SCISSORS;
		} //ランダムな手がの場パーの場合
		else if (randomNumber < PAPER_RANGE) {
			//プレイヤーの手にグーを代入
			playerHand = HAND_PAPER;
		}
		//プレイヤーの手を返却
		return playerHand;
	}

	/*関数名:notifyResoult
	 *概要:勝ったプレイヤーの勝利数を増加
	 *引数:勝負結果(boolean)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public void notifyResoult(boolean resultValue) {
		//じゃんけんに勝った場合実行
		if (resultValue = true) {
			//勝利数を1増加
			winCount++;
		}
	}

	/*関数名:getWinCount
	 *概要:勝利数を返却
	 *引数:なし
	 *戻り値:勝利数(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int getWinCount() {
		//勝利数を返却
		return winCount;
	}

}
