package work7_3;

/*クラス名:Card
 *概要:トランプのカードを管理
 *作成者:K.Asakura
 *作成日:2024/07/02
 */
public class Card {
	//ジョーカーを定数化
	public static final int CARD_JOKER = 0;
	//スペードを定数化
	public static final int SUIT_SPADE = 1;
	//ダイヤを定数化
	public static final int SUIT_DIAMOND = 2;
	//クラブを定数化
	public static final int SUIT_CLUB = 3;
	//ハートを定数化
	public static final int SUIT_HEART = 4;
	//カード番号1を定数化
	public static final int NUMBER_ACE = 1;
	//カード番号10を定数化
	public static final int NUMBER_TEN = 10;
	//カード番号11を定数化
	public static final int NUMBER_JACK = 11;
	//カード番号12を定数化
	public static final int NUMBER_QUEEN = 12;
	//カード番号13を定数化
	public static final int NUMBER_KING = 13;
	//スートを表すint型のフィールド宣言
	private int cardSuit;
	//カード番号を表すint型のフィールド宣言
	private int cardNumber;

	/*コンストラクタ名:Card
	 *概要:フィールドを仮引数で初期化
	 *引数:スート、カード番号(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public Card(int cardSuit, int cardNumber) {
		//スートを表すフィールドを仮引数で初期化
		this.cardSuit = cardSuit;
		//カード番号を表すフィールドを仮引数で初期化
		this.cardNumber = cardNumber;
	}

	/*関数名:getNumber
	 *概要:カード番号を取得
	 *引数:なし
	 *戻り値:カード番号(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public int getNumber() {
		//カード番号を返却
		return cardNumber;
	}

	/*関数名:toString
	 *概要:カード番号とスートの文字列表現を返却
	 *引数:なし
	 *戻り値:カード番号とスートの文字列(String)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public String toString() {
		//文字列を格納するためのインスタンスを生成
		StringBuffer string = new StringBuffer();
		//ジョーカー以外の場合
		if (cardNumber > 0) {
			//スートによって飛び先を変更
			switch (cardSuit) {
			//スペードの場合
			case SUIT_SPADE:
				//Sと表示
				string.append("S");
				//switch文を抜け出る
				break;
			//ダイヤの場合
			case SUIT_DIAMOND:
				//Dと表示
				string.append("D");
				//switch文を抜け出る
				break;
			//クラブの場合
			case SUIT_CLUB:
				//Cと表示
				string.append("C");
				//switch文を抜け出る
				break;
			//ハートの場合
			case SUIT_HEART:
				//Hと表示
				string.append("H");
				//switch文を抜け出る
				break;
			}
			//数字によって飛び先を変更
			switch (cardNumber) {
			//1の場合
			case NUMBER_ACE:
				//Aと表示
				string.append("A");
				//switch文を抜け出る
				break;
			//10の場合
			case NUMBER_TEN:
				//Tと表示
				string.append("T");
				//switch文を抜け出る
				break;
			//11の場合
			case NUMBER_JACK:
				//Jと表示
				string.append("J");
				//switch文を抜け出る
				break;
			//12の場合
			case NUMBER_QUEEN:
				//Qと表示
				string.append("Q");
				//switch文を抜け出る
				break;
			//13の場合
			case NUMBER_KING:
				//Kと表示
				string.append("K");
				//switch文を抜け出る
				break;
			}
		//ジョーカーの場合
		}else {
			//JKと表示
			string.append("JK");
		}
		//文字列を返却
		return string.toString();
	}

}
