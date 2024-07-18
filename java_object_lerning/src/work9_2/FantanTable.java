package work9_2;

//TrumpパッケージのCardクラスをインポート
import Trump.Card;
import Trump.Table;

/*クラス名:fantanTable
 *概要:七並べのテーブルを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class FantanTable implements Table {
	//カードを並べるテーブルを表す二次元配列を生成
	private Card[][] trampTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];

	/*関数名:putCard
	 *概要:カードを置く
	 *引数:置くことのできるカード(Card型の配列)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void putCard(Card[] handCard) {
		//インデックスを調節するため引かれる数を定数化
		final int ADJUSTMENT_INDEX = -1;
		//先頭のインデックスを定数化
		final int INDEX_NUMBER_ZERO = 0;
		//カード番号を表す変数に仮引数のカード番号を代入
		int cardNumber = handCard[INDEX_NUMBER_ZERO].getNumber();
		//スートを表す変数に仮引数のスートを代入
		int suitNumber = handCard[INDEX_NUMBER_ZERO].getSuit();
		//テーブルにカードを置く
		trampTable[suitNumber + ADJUSTMENT_INDEX][cardNumber + ADJUSTMENT_INDEX] = handCard[INDEX_NUMBER_ZERO];
	}

	/*関数名:getCards
	 *概要:テーブルに置かれたカードを取得
	 *引数:なし
	 *戻り値:テーブルに置かれたカード(Card型の二次元配列)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card[][] getCards() {
		//テーブルに置かれたカードを返却
		return trampTable;
	}

	/*関数名:toString
	 *概要:七並べを表示する文字列を返却
	 *引数:なし
	 *戻り値:七並べを表示する文字列(String)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public String toString() {
		//文字列を格納するためのインスタンスを生成
		StringBuffer tableString = new StringBuffer();
		//スートの数だけ縦列にカードを並べる
		for (int cardSuit = 0; cardSuit < Card.SUIT_NUMBER; cardSuit++) {
			//7を中心に並べることのできるカードを並べる
			for (int cardNumber = 0; cardNumber < Card.CARD_NUMBER; cardNumber++) {
				//並べられる場合
				if (trampTable[cardSuit][cardNumber] != null) {
					//テーブルにカードを並べる
					tableString.append(trampTable[cardSuit][cardNumber]);
					//並べられない場合
				} else {
					//..を出力
					tableString.append("..");
				}
				//空白を出力
				tableString.append(" ");
			}
			//改行を出力
			tableString.append("\n");
		}
		//七並べを表示する文字列を返却
		return tableString.toString();
	}

}
