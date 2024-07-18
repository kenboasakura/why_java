package Trump;

/*クラス名:Joker
 *概要:トランプのジョーカーを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class Joker extends Card{
	//ジョーカーを表すスートを定数化
	static final int JOKER_SUIT = 0;
	//ジョーカーを表す番号を定数化
	static final int JOKER_NUMBER = 0;

	/*コンストラクタ名:Joker
	 *概要:ジョーカーをスーパークラスのコンストラクタで初期化
	 *引数:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Joker() {
		
		
		//スーパークラスのコンストラクタを呼び出す
		super(JOKER_SUIT, JOKER_NUMBER);
	}
	
	/*関数名:setNumber
	 *概要:カード番号を取得
	 *引数:なし
	 *戻り値:カード番号(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void setNumber(int cardNumber) {
		//カード番号を返却
		this.cardNumber = cardNumber;
	}
	
	/*関数名:main
	 *概要:スートを取得
	 *引数:なし
	 *戻り値:スート(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void setSuit(int cardSuit) {
		//スートを返却
		this.cardSuit = cardSuit;
	}
	
	/*関数名:main
	 *概要:カード番号とスートの文字列表現を返却
	 *引数:なし
	 *戻り値:カード番号とスートの文字列(String)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public String toString() {
		//ジョーカーの文字列表現を返却
		return "JK";
	}
}
