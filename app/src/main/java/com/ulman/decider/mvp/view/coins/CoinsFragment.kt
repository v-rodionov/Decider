package com.ulman.decider.mvp.view.coins

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ulman.decider.R
import com.ulman.decider.mvp.presenter.coins.CoinsChoice
import com.ulman.decider.mvp.presenter.coins.CoinsChoiceType
import com.ulman.decider.mvp.presenter.coins.CoinsPresenter
import kotlinx.android.synthetic.main.fragment_coins.*
import javax.inject.Inject

class CoinsFragment : Fragment(), CoinsView {

    @Inject lateinit var presenter: CoinsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_coins, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onPause() {
        super.onPause()
        presenter.stop()
    }

    override fun setChoice(choice: CoinsChoice) {

        val text = if (choice.type == CoinsChoiceType.YES) Phrase.COINS_PHRASE_YES[choice.phrase] else Phrase.COINS_PHRASE_NO[choice.phrase]
        phraseField.text = getString(text)
    }

}


