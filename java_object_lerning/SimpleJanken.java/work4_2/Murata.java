package work4_2;

/*クラス名:Murata
 *概要:村田さんを管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class Murata extends Player{
	
	/*関数名:Murata
	 *概要:名前をスーパークラスのコンストラクタで初期化
	 *引数:名前(String)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public Murata(String playerName) {
		//superクラスのコンストラクタを呼び出す
		super(playerName);
	}

	//グーを定数化
	public static final int HAND_STONE = 0;

	/*関数名:showHand
	 *概要:グーを返却するメソッド
	 *引数:なし
	 *戻り値:グー(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int showHand() {
		//グーを返却
		return HAND_STONE;
	}

}
