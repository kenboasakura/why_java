package Trump;

/*クラス名:Card
 *概要:カードを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class Card {
	//スペードを定数化
	public static final int SUIT_SPADE = 1;
	//ダイヤを定数化
	public static final int SUIT_DIAMOND = 2;
	//クラブを定数化
	public static final int SUIT_CLUB = 3;
	//ハートを定数化
	public static final int SUIT_HEART = 4;
	//スートの種類数を定数化
	public static final int SUIT_NUMBER = 4;
	//数字の種類数を定数化
	public static final int CARD_NUMBER = 13;
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
	//スートを表すint型のフィールドを初期化して宣言
	protected int cardSuit = 0;
	//カード番号を表すint型のフィールドを初期化して宣言
	protected int cardNumber = 0;

	/*コンストラクタ名:Card
	 *概要:カード情報を仮引数で初期化
	 *引数:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
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

	/*関数名:getSuit
	 *概要:スートを取得
	 *引数:なし
	 *戻り値:スート(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/02
	 */
	public int getSuit() {
		//スートを返却
		return cardSuit;
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
		StringBuffer cardString = new StringBuffer();
		//スートによって飛び先を変更
		switch (cardSuit) {
		//スペードの場合
		case SUIT_SPADE:
			//Sと表示
			cardString.append("S");
			//switch文を抜け出る
			break;
		//ダイヤの場合
		case SUIT_DIAMOND:
			//Dと表示
			cardString.append("D");
			//switch文を抜け出る
			break;
		//クラブの場合
		case SUIT_CLUB:
			//Cと表示
			cardString.append("C");
			//switch文を抜け出る
			break;
		//ハートの場合
		case SUIT_HEART:
			//Hと表示
			cardString.append("H");
			//switch文を抜け出る
			break;
		}
		//数字によって飛び先を変更
		switch (cardNumber) {
		//1の場合
		case NUMBER_ACE:
			//Aと表示
			cardString.append("A");
			//switch文を抜け出る
			break;
		//10の場合
		case NUMBER_TEN:
			//Tと表示
			cardString.append("T");
			//switch文を抜け出る
			break;
		//11の場合
		case NUMBER_JACK:
			//Jと表示
			cardString.append("J");
			//switch文を抜け出る
			break;
		//12の場合
		case NUMBER_QUEEN:
			//Qと表示
			cardString.append("Q");
			//switch文を抜け出る
			break;
		//13の場合
		case NUMBER_KING:
			//Kと表示
			cardString.append("K");
			//switch文を抜け出る
			break;
		//それ以外の数字の場合
		default:
			//Kと表示
			cardString.append(cardNumber);
			//switch文を抜け出る
			break;
		}

		//文字列を返却
		return cardString.toString();
	}

}
