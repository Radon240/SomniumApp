import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somniumapp.R
import com.example.somniumapp.features.article.model.GetArticleResponse

class Gameplay : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gameplay, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val articlesList: List<GetArticleResponse> =  //createDummyArticles
        articleAdapter = ArticleAdapter(articlesList)
        recyclerView.adapter = articleAdapter

        return view
    }

    /*private fun createDummyArticles(): List<GetArticleResponse> {
        val articles = mutableListOf<GetArticleResponse>()
        articles.add(GetArticleResponse("Заголовок 1", " "))
        articles.add(GetArticleResponse("Заголовок 2", "ArticleAdapter."))
        // Добавьте другие статьи по вашему усмотрению
        return articles
    }*/
}
