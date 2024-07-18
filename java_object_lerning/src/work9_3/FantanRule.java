package work9_3;
//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのHandクラスをインポート
import Trump.Hand;
//TrumpパッケージのRuleクラスをインポート
import Trump.Rule;
//TrumpパッケージのTableクラスをインポート
import Trump.Table;

/*クラス名:FantanRule
 *概要:七並べのルールを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class FantanRule implements Rule {

	/*関数名:findCandidate
	 *概要:七並べのルールを管理
	 *引数:自分の手札(Hand)、試合中のテーブル(Table)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Card[] findCandidate(Hand myHand, Table gametTable) {
		//先頭のインデックスを定数化
		final int INDEX_NUMBER_ZERO = 0;
		//置けるカードの枚数を定数化
		final int CANDIDATE_CARD_SIZE = 1;
		//注目している左のカードを表すため引かれる整数を定数化
		final int LEFT_SIDE_CARD = -1;
		//注目している右のカードを表すため引かれる整数を定数化
		final int RIGHT_SIDE_CARD = 1;
		//テーブルに置けるカードを格納する配列を規定値で宣言
		Card[] canPutOnCard = null;
		//自分の手札の枚数をその枚数で初期化して宣言
		int numberOfHand = myHand.getNumberOfCards();
		//手札にあるカードをテーブルに置けるか確認しする
		for (int cardPosition = 0; cardPosition < numberOfHand; cardPosition++) {
			//手札のカードを見てそのカードを代入
			Card lookingCard = myHand.lookCard(cardPosition);
			//そのカードの数字を代入
			int cardNumber = lookingCard.getNumber();
			//そのカードのスートを代入
			int cardSuit = lookingCard.getSuit();
			//テーブルに置かれている各スートの一番小さい数から1引いた数を代入
			int leftNumber = (cardNumber != Card.NUMBER_ACE) ? cardNumber + LEFT_SIDE_CARD : Card.CARD_NUMBER;
			//テーブルに置かれている各スートの一番大きい数から1たした数を代入
			int rightNumber = (cardNumber != Card.CARD_NUMBER) ? cardNumber + RIGHT_SIDE_CARD : Card.NUMBER_ACE;
			//今注目している手札の左か右にカードがある場合
			if ((true == isThereCard(gametTable, cardSuit, leftNumber)) ||
					(true == isThereCard(gametTable, cardSuit, rightNumber))) {
				//置けるカードの候補を作成
				canPutOnCard = new Card[CANDIDATE_CARD_SIZE];
				//置けるカードを引く
				canPutOnCard[INDEX_NUMBER_ZERO]= myHand.pickCard(cardPosition);
				//ループを終了
				break;
			}
		}
		//置けるカードを返却
		return canPutOnCard;
	}

	/*関数名:isThereCard
	 *概要:カードがあるか確認する
	 *引数:試合中のテーブル(Table)、テーブルのスートと番号(int)
	 *戻り値:カードがあるかどうか(boolean)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public boolean isThereCard(Table gametTable, int cardSuit, int cardNumber) {
		//インデックスを調節するため引かれる数を定数化
		final int ADJUSTMENT_INDEX = -1;
		//カードがあるか確認する倫理型の変数をfalseで初期化
		boolean isThereCard = false;
		//テーブルのカードを表すCard型の配列を生成
		Card[][] tableCards = gametTable.getCards();
		//カードがある場合
		if (tableCards[cardSuit + ADJUSTMENT_INDEX][cardNumber + ADJUSTMENT_INDEX] != null) {
			//trueを代入
			isThereCard = true;
		}
		//カードがあるか確認する倫理型の変数を返却
		return isThereCard;
	}

}
