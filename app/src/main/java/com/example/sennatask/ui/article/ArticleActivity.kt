package com.example.sennatask.ui.article


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sennatask.R
import com.example.sennatask.ViewModelFactory
import com.example.sennatask.databinding.ActivityArticleBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ArticleActivity : DaggerAppCompatActivity() {



    private lateinit var viewModel: ArticleViewModel
    private lateinit var binding: ActivityArticleBinding

    lateinit var articleAdapter: ArticleAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_article)

        viewModel = ViewModelProvider(this,viewModelFactory)[ArticleViewModel::class.java]
        setUpRecyclerView()
        viewModel.getArticles()

        viewModel.articles.observe(this){articles->
            if (articles!=null){
//                Log.e("TAG",articles.toString())
                articleAdapter.setList(articles)
            }
        }

    }


    private fun setUpRecyclerView(){
        binding.articleRv.layoutManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter()
        binding.articleRv.adapter = articleAdapter
        binding.articleRv.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

    }


}