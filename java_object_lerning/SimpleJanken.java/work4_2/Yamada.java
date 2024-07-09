package work4_2;

/*クラス名:Yamada
 *概要:山田さんを管理
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class Yamada extends Player{
	
	//パーを定数化
		public static final int HAND_PAPER = 2;
	
	/*関数名:Yamada
	 *概要:名前をスーパークラスのコンストラクタで初期化
	 *引数:名前(String)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public Yamada(String playerName) {
		//superクラスのコンストラクタを呼び出す
		super(playerName);
	}

	/*関数名:showHand
	 *概要:パーを返却
	 *引数:なし
	 *戻り値:パー(int)
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
	public int showHand() {
		//パーを返却
		return HAND_PAPER;
	}

}