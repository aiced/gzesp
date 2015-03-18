package com.ai.sysframe.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.ai.sysframe.utils.DateUtil;
/**
 * @ClassName: StringTypeHandler
 * @Description: 自定义mybatis的jdbc转String处理类
 * @author linyl linyuliang.85@gmail.com
 */
public class StringTypeHandler extends BaseTypeHandler<Object> {
    
    @Override
    public void setParameter(final PreparedStatement ps, final int i, final Object parameter, final JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setString(i, "");
        } else {
            ps.setString(i, parameter.toString());
        }
    }
    
    @Override
    public Object getResult(final ResultSet resultset, final String columnName) throws SQLException {
        final Object s = resultset.getObject(columnName);
        if (s == null) {
            return "";
        } else {
            if (s instanceof Date) {
                return DateUtil.getFomartDate((Date) s, "yyyy-MM-dd HH:mm:ss");
            } else {
                return s.toString();
            }
        }
    }
    
    @Override
    public Object getResult(final CallableStatement callablestatement, final int columnIndex) throws SQLException {
        final Object s = callablestatement.getObject(columnIndex);
        if (s == null) {
            return "";
        } else {
            if (s instanceof Date) {
                return DateUtil.getFomartDate((Date) s, "yyyy-MM-dd HH:mm:ss");
            } else {
                return s.toString();
            }
        }
    }
    
    @Override
    public Object getNullableResult(final ResultSet resultset, final String columnName) throws SQLException {
        final Object s = resultset.getObject(columnName);
        if (s == null) {
            return "";
        } else {
            if (s instanceof Date) {
                return DateUtil.getFomartDate((Date) s, "yyyy-MM-dd HH:mm:ss");
            } else {
                return s.toString();
            }
        }
    }
    
    @Override
    public Object getNullableResult(final CallableStatement callablestatement, final int columnIndex) throws SQLException {
        final Object s = callablestatement.getObject(columnIndex);
        if (s == null) {
            return "";
        } else {
            if (s instanceof Date) {
                return DateUtil.getFomartDate((Date) s, "yyyy-MM-dd HH:mm:ss");
            } else {
                return s.toString();
            }
        }
    }
    
    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i, final Object parameter, final JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
