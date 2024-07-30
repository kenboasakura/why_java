package work9_6;
//ArrayListクラスをインポート
import java.util.ArrayList;

//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのTableインタフェースをインポート
import Trump.Table;

/*クラス名:OldMaidTable
 *概要:ばば抜きのテーブルを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class OldMaidTable implements Table {
	//テーブルに置かれたカードを格納する配列を生成
	private ArrayList<Card> disposedCards = new ArrayList<Card>();
	
	/*関数名:putCard
	 *概要:テーブルにカードを置く
	 *引数:捨てるカード(Card型の配列)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void putCard(Card[] handCard) {
		//同じ数字のカードをテーブルに追加
		for(int i = 0;i< handCard.length;i++) {
			//捨てるカードを表示
			System.out.print(handCard[i]+" ");
			//捨てられたカードをテーブルに追加
			disposedCards.add(handCard[i]);
		}
		//捨てましたと表示
		System.out.println("を捨てました");
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
		return null;
	}

}
