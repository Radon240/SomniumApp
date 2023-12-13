import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somniumapp.R
import com.example.somniumapp.features.article.ArticleAdapter
import com.example.somniumapp.features.article.ArticleRepository
import org.koin.android.ext.android.inject

class ArticlesByCategoryFragment(private val category: String) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: ArticleAdapter
    private val articleRepository: ArticleRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_articles_by_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        customAdapter = ArticleAdapter(articleRepository.getArticles(category)!!)
        recyclerView.adapter = customAdapter
    }
}
