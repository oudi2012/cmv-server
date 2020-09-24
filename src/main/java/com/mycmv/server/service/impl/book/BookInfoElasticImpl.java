package com.mycmv.server.service.impl.book;

import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.esmapper.BookInfoElasticMapper;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.service.InfoElasticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/***
 * @author a
 */
@Service("bookInfoElastic")
public class BookInfoElasticImpl implements InfoElasticService<BookInfoEs> {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.SYS_LOG);

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private BookInfoElasticMapper bookInfoElasticMapper;

    @Override
    public void createIndex(Class<BookInfoEs> clazz) {
        if (elasticsearchRestTemplate.indexExists(clazz)) {
            logger.error(" idxName={} 已经存在", clazz.getAnnotation(Document.class));
            return;
        }
        elasticsearchRestTemplate.createIndex(clazz);
        elasticsearchRestTemplate.putMapping(clazz);
    }

    @Override
    public boolean isExistsIndex(Class<BookInfoEs> clazz) {
        return elasticsearchRestTemplate.indexExists(clazz);
    }

    @Override
    public void insertOrUpdateOne(BookInfoEs item) {
        bookInfoElasticMapper.save(item);
    }

    @Override
    public void insertBatch(List<BookInfoEs> list) {
        bookInfoElasticMapper.saveAll(list);
    }

    @Override
    public int deleteBatch(List<BookInfoEs> list) {
        bookInfoElasticMapper.deleteAll(list);
        return list.size();
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            bookInfoElasticMapper.deleteById(id);
        }
        return ids.size();
    }

    @Override
    public Page<BookInfoEs> search(BookInfoEs item, Pageable pageable) {
        return bookInfoElasticMapper.search(getElasticQuery(item), pageable);
    }

    @Override
    public void deleteIndex(Class<BookInfoEs> clazz) {
        elasticsearchRestTemplate.deleteIndex(clazz);
    }

    @Override
    public void delete(BookInfoEs item) {
        bookInfoElasticMapper.delete(item);
    }
}
