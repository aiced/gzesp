package com.ai.sysframe.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.springframework.util.Assert;

import com.ai.sysframe.exception.BaseException;

/**
 * @ClassName: ReflectUtil
 * @Description: java反射机制工具类
 * @author linyl linyuliang.85@gmail.com
 */
public class ReflectUtil {
    /**
     * Pre-built FieldFilter that matches all non-static, non-final fields.
     */
    public static FieldFilter copyableFields = new FieldFilter() {
        
        public boolean matches(final Field field) {
            return !(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()));
        }
    };

    /**
     * @Title: getStaticField
     * @Description: 利用java反射机制获取静态参数
     * @param className 类名
     * @param fieldName 参数名
     * @return Object 返回静态参数对象
     * @throws BaseException 异常
     */
    public static final Object getStaticField(final String className, final String fieldName) throws BaseException {
        Class<?> c;
        try {
            c = Class.forName(className);
        } catch (final ClassNotFoundException e) {
            throw new BaseException("8", e, new Object[] { className });
        }
        Field f = null;
        try {
            f = c.getField(fieldName);
        } catch (final SecurityException e) {
            throw new BaseException("38", e, new Object[] { className, fieldName });
        } catch (final NoSuchFieldException e) {
            throw new BaseException("39", e, new Object[] { className, fieldName });
        }
        try {
            return f.get(null);
        } catch (final IllegalArgumentException e) {
            throw new BaseException("40", e, new Object[] { className, fieldName });
        } catch (final IllegalAccessException e) {
            throw new BaseException("41", e, new Object[] { className, fieldName });
        }
    }

    /**
     * @Title: invokeStaticMethod
     * @Description: 利用java反射机制调用静态方法
     * @param className 类名
     * @param methodName 方法名
     * @param params 参数列表
     * @return Object 返回类型
     * @throws BaseException 异常
     */
    public static final Object invokeStaticMethod(final String className, final String methodName, final Object[] params) throws BaseException {
        Class<?> c;
        try {
            c = Class.forName(className);
        } catch (final ClassNotFoundException e) {
            throw new BaseException("8", e, new Object[] { className });
        }
        final Method m;
        try {
            final Class<?>[] classLists = new Class<?>[params.length];
            for (int i = 0; i < params.length; i = i + 1) {
                if (params[i] instanceof Document) {
                    classLists[i] = Document.class;
                } else {
                    classLists[i] = params[i].getClass();
                }
            }
            m = c.getMethod(methodName, classLists);
        } catch (final SecurityException e) {
            throw new BaseException("9", e, new Object[] { className, methodName, params });
        } catch (final NoSuchMethodException e) {
            throw new BaseException("10", e, new Object[] { className, methodName, params });
        }
        try {
            return m.invoke(c, params);
        } catch (final IllegalArgumentException e) {
            throw new BaseException("11", e, new Object[] { className, methodName, params });
        } catch (final IllegalAccessException e) {
            throw new BaseException("12", e, new Object[] { className, methodName, params });
        } catch (final InvocationTargetException e) {
            throw new BaseException("13", e, new Object[] { className, methodName, params });
        }
    }

    /**
     * 根据类和属性名称查找属性字段 Attempt to find a {@link Field field} on the supplied
     * {@link Class} with the supplied <code>name</code>. Searches all
     * superclasses up to {@link Object}.
     * @param clazz the Class<?> to introspect
     * @param name the name of the field
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(final Class<?> clazz, final String name) {
        return findField(clazz, name, null);
    }

    /**
     * 根据类和属性名称查找属性字段 Attempt to find a {@link Field field} on the supplied
     * {@link Class} with the supplied <code>name</code> and/or {@link Class
     * type}. Searches all superclasses up to {@link Object}.
     * @param clazz the Class<?> to introspect
     * @param name the name of the field (may be <code>null</code> if type is
     *        specified)
     * @param type the type of the field (may be <code>null</code> if name is
     *        specified)
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(final Class<?> clazz, final String name, final Class<?> type) {
        Assert.notNull(clazz, "Class<?> must not be null");
        Assert.isTrue(name != null || type != null, "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            final Field[] fields = searchType.getDeclaredFields();
            for (final Field field : fields) {
                if ((name == null || name.equals(field.getName())) && (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 根据属性字段和对象，设置对象的值 Set the field represented by the supplied {@link Field
     * field object} on the specified {@link Object target object} to the
     * specified <code>value</code>. In accordance with
     * {@link Field#set(Object, Object)} semantics, the new value is
     * automatically unwrapped if the underlying field has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException(Exception)}.
     * @param field the field to set
     * @param target the target object on which to set the field
     * @param value the value to set; may be <code>null</code>
     */
    public static void setField(final Field field, final Object target, final Object value) {
        try {
            field.set(target, value);
        } catch (final IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * 根据属性字段和对象，获取的对象中字段的值 Get the field represented by the supplied
     * {@link Field field object} on the specified {@link Object target object}.
     * In accordance with {@link Field#get(Object)} semantics, the returned
     * value is automatically wrapped if the underlying field has a primitive
     * type.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException(Exception)}.
     * @param field the field to get
     * @param target the target object from which to get the field
     * @return the field's current value
     */
    public static Object getField(final Field field, final Object target) {
        try {
            return field.get(target);
        } catch (final IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * 根据类，方法名称和参数类型查找方法 Attempt to find a {@link Method} on the supplied class
     * with the supplied name and no parameters. Searches all superclasses up to
     * <code>Object</code>.
     * <p>
     * Returns <code>null</code> if no {@link Method} can be found.
     * @param clazz the Class<?> to introspect
     * @param name the name of the method
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(final Class<?> clazz, final String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * 根据类，方法名称和参数类型查找方法 Attempt to find a {@link Method} on the supplied class
     * with the supplied name and parameter types. Searches all superclasses up
     * to <code>Object</code>.
     * <p>
     * Returns <code>null</code> if no {@link Method} can be found.
     * @param clazz the Class<?> to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method (may be
     *        <code>null</code> to indicate any signature)
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(final Class<?> clazz, final String name, final Class<?>[] paramTypes) {
        Assert.notNull(clazz, "Class<?> must not be null");
        Assert.notNull(name, "Method name must not be null");
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            final Method[] methods = searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods();
            for (final Method method : methods) {
                if (name.equals(method.getName()) && (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * 调用方法的应用 Invoke the specified {@link Method} against the supplied target
     * object with no arguments. The target object can be <code>null</code> when
     * invoking a static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException}.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeMethod(final Method method, final Object target) {
        return invokeMethod(method, target, null);
    }

    /**
     * 调用方法的应用 Invoke the specified {@link Method} against the supplied target
     * object with the supplied arguments. The target object can be
     * <code>null</code> when invoking a static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException}.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be <code>null</code>)
     * @return the invocation result, if any
     */
    public static Object invokeMethod(final Method method, final Object target, final Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (final IllegalArgumentException e) {
            handleReflectionException(e);
        } catch (final IllegalAccessException e) {
            handleReflectionException(e);
        } catch (final InvocationTargetException e) {
            handleReflectionException(e);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with no arguments.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeJdbcMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(final Method method, final Object target) throws SQLException {
        return invokeJdbcMethod(method, target, null);
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with the supplied arguments.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be <code>null</code>)
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(final Method method, final Object target, final Object[] args) throws SQLException {
        try {
            return method.invoke(target, args);
        } catch (final IllegalAccessException ex) {
            handleReflectionException(ex);
        } catch (final InvocationTargetException ex) {
            if (ex.getTargetException() instanceof SQLException) {
                throw (SQLException) ex.getTargetException();
            }
            handleInvocationTargetException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**************************************************************
     * 处理异常的方法
     ***************************************************************/

    /**
     * 使用反射处理异常的将异常信息输出但不抛出方法以外 Handle the given reflection exception. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of an
     * InvocationTargetException with such a root cause. Throws an
     * IllegalStateException with an appropriate message else.
     * @param ex the reflection exception to handle
     */
    public static void handleReflectionException(final Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + ex.getMessage());
        }
        if (ex instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method: " + ex.getMessage());
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Handle the given invocation target exception. Should only be called if no
     * checked exception is expected to be thrown by the target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of such a root
     * cause. Throws an IllegalStateException else.
     * @param ex the invocation target exception to handle
     */
    public static void handleInvocationTargetException(final InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the
     * <em>target exception</em> of an {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Rethrows the underlying exception cast to an {@link RuntimeException} or
     * {@link Error} if appropriate; otherwise, throws an
     * {@link IllegalStateException}.
     * @param ex the exception to rethrow
     * @throws RuntimeException the rethrown exception
     */
    public static void rethrowRuntimeException(final Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the
     * <em>target exception</em> of an {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Rethrows the underlying exception cast to an {@link Exception} or
     * {@link Error} if appropriate; otherwise, throws an
     * {@link IllegalStateException}.
     * @param ex the exception to rethrow
     * @throws Exception the rethrown exception (in case of a checked exception)
     */
    public static void rethrowException(final Throwable ex) throws Exception {
        if (ex instanceof Exception) {
            throw (Exception) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Throws an IllegalStateException with the given exception as root cause.
     * @param ex the unexpected exception
     */
    private static void handleUnexpectedException(final Throwable ex) {
        // Needs to avoid the chained constructor for JDK 1.4 compatibility.
        final IllegalStateException isex = new IllegalStateException("Unexpected exception thrown");
        isex.initCause(ex);
        throw isex;
    }

    /**
     * Determine whether the given method explicitly declares the given
     * exception or one of its superclasses, which means that an exception of
     * that type can be propagated as-is within a reflective invocation.
     * @param method the declaring method
     * @param exceptionType the exception to throw
     * @return <code>true</code> if the exception can be thrown as-is;
     *         <code>false</code> if it needs to be wrapped
     */
    public static boolean declaresException(final Method method, final Class<?> exceptionType) {
        Assert.notNull(method, "Method must not be null");
        final Class<?>[] declaredExceptions = method.getExceptionTypes();
        for (final Class<?> declaredException : declaredExceptions) {
            if (declaredException.isAssignableFrom(exceptionType)) {
                return true;
            }
        }
        return false;
    }

    /*************************************************************
     * 判断方法，属性字段等的修饰符的方法
     *************************************************************/
    /**
     * Determine whether the given field is a "public static final" constant.
     * @param field the field to check
     * @return 是否公开静态只读变量
     */
    public static boolean isPublicStaticFinal(final Field field) {
        final int modifiers = field.getModifiers();
        return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
    }

    /**
     * Determine whether the given method is an "equals" method.
     * @see java.lang.Object#equals
     * @param method 给定方法
     * @return 给定方法是否是equals方法
     */
    public static boolean isEqualsMethod(final Method method) {
        if (method == null || !method.getName().equals("equals")) {
            return false;
        }
        final Class<?>[] paramTypes = method.getParameterTypes();
        return paramTypes.length == 1 && paramTypes[0] == Object.class;
    }

    /**
     * @return Determine whether the given method is a "hashCode" method.
     * @param method 给定方法
     * @see java.lang.Object#hashCode
     */
    public static boolean isHashCodeMethod(final Method method) {
        return method != null && method.getName().equals("hashCode") && method.getParameterTypes().length == 0;
    }

    /**
     * @param method 给定方法
     * @return Determine whether the given method is a "toString" method.
     * @see java.lang.Object#toString()
     */
    public static boolean isToStringMethod(final Method method) {
        return method != null && method.getName().equals("toString") && method.getParameterTypes().length == 0;
    }

    /**
     * 判断一个属性是否可以访问的方法 Make the given field accessible, explicitly setting it
     * accessible if necessary. The <code>setAccessible(true)</code> method is
     * only called when actually necessary, to avoid unnecessary conflicts with
     * a JVM SecurityManager (if active).
     * @param field the field to make accessible
     * @see java.lang.reflect.Field#setAccessible
     */
    public static void makeAccessible(final Field field) {
        if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            field.setAccessible(true);
        }
    }

    /**
     * 判断一个方法是否可以访问的方法 Make the given method accessible, explicitly setting it
     * accessible if necessary. The <code>setAccessible(true)</code> method is
     * only called when actually necessary, to avoid unnecessary conflicts with
     * a JVM SecurityManager (if active).
     * @param method the method to make accessible
     * @see java.lang.reflect.Method#setAccessible
     */
    public static void makeAccessible(final Method method) {
        if (!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            method.setAccessible(true);
        }
    }

    /**
     * 判断一个构造函数是否可以访问的方法 Make the given constructor accessible, explicitly
     * setting it accessible if necessary. The <code>setAccessible(true)</code>
     * method is only called when actually necessary, to avoid unnecessary
     * conflicts with a JVM SecurityManager (if active).
     * @param ctor the constructor to make accessible
     * @see java.lang.reflect.Constructor#setAccessible
     */
    public static void makeAccessible(final Constructor<?> ctor) {
        if (!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers())) {
            ctor.setAccessible(true);
        }
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * Class<?> and superclasses.
     * <p>
     * The same named method occurring on subClass<?> and superClass<?> will
     * appear twice, unless excluded by a {@link MethodFilter}.
     * @param targetClass Class<?> to start looking at
     * @param mc the callback to invoke for each method
     * @see #doWithMethods(Class, MethodCallback, MethodFilter)
     * @throws IllegalArgumentException 非法参数
     */
    public static void doWithMethods(final Class<?> targetClass, final MethodCallback mc) throws IllegalArgumentException {
        doWithMethods(targetClass, mc, null);
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * Class<?> and superclasses.
     * <p>
     * The same named method occurring on subClass<?> and superClass<?> will
     * appear twice, unless excluded by the specified {@link MethodFilter}.
     * @param targetClass Class<?> to start looking at
     * @param mc the callback to invoke for each method
     * @param mf the filter that determines the methods to apply the callback to
     * @throws IllegalArgumentException 非法参数
     */
    public static void doWithMethods(final Class<?> targetClass, final MethodCallback mc, final MethodFilter mf) throws IllegalArgumentException {
        // Keep backing up the inheritance hierarchy.
        Class<?> executeClass = targetClass;
        do {
            final Method[] methods = executeClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (mf != null && !mf.matches(methods[i])) {
                    continue;
                }
                try {
                    mc.doWith(methods[i]);
                } catch (final IllegalAccessException ex) {
                    throw new IllegalStateException("Shouldn't be illegal to access method '" + methods[i].getName() + "': " + ex);
                }
            }
            executeClass = executeClass.getSuperclass();
        } while (targetClass != null);
    }

    /**
     * 获取类的所有的方法的 Get all declared methods on the leaf Class<?> and all
     * superclasses. Leaf Class<?> methods are included first.
     * @param leafClass 指定类
     * @throws IllegalArgumentException 非法参数
     * @return 返回方法列表
     */
    public static Method[] getAllDeclaredMethods(final Class<?> leafClass) throws IllegalArgumentException {
        final List<Method> list = new ArrayList<Method>(32);
        doWithMethods(leafClass, new MethodCallback() {
            
            public void doWith(final Method method) {
                list.add(method);
            }
        });
        return list.toArray(new Method[list.size()]);
    }

    /**
     * 调用字段时执行的回调的方法 Invoke the given callback on all fields in the target
     * class, going up the Class<?> hierarchy to get all declared fields.
     * @param targetClass the target Class<?> to analyze
     * @param fc the callback to invoke for each field
     * @throws IllegalArgumentException 非法参数
     */
    public static void doWithFields(final Class<?> targetClass, final FieldCallback fc) throws IllegalArgumentException {
        doWithFields(targetClass, fc, null);
    }

    /**
     * 调用字段时执行的回调的并过滤的方法 Invoke the given callback on all fields in the target
     * class, going up the Class<?> hierarchy to get all declared fields.
     * @param targetClass the target Class<?> to analyze
     * @param fc the callback to invoke for each field
     * @param ff the filter that determines the fields to apply the callback to
     * @throws IllegalArgumentException 非法参数
     */
    public static void doWithFields(final Class<?> targetClass, final FieldCallback fc, final FieldFilter ff) throws IllegalArgumentException {
        Class<?> executeClass = targetClass;
        // Keep backing up the inheritance hierarchy.
        do {
            // Copy each field declared on this Class<?> unless it's static or
            // file.
            final Field[] fields = executeClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                // Skip static and final fields.
                if (ff != null && !ff.matches(fields[i])) {
                    continue;
                }
                try {
                    fc.doWith(fields[i]);
                } catch (final IllegalAccessException ex) {
                    throw new IllegalStateException("Shouldn't be illegal to access field '" + fields[i].getName() + "': " + ex);
                }
            }
            executeClass = executeClass.getSuperclass();
        } while (executeClass != null && executeClass != Object.class);
    }

    /**
     * 用于对象的拷贝的方法（类必须是同一类或子类） Given the source object and the destination, which
     * must be the same Class<?> or a subclass, copy all fields, including
     * inherited fields. Designed to work on objects with public no-arg
     * constructors.
     * @param src 被拷贝对象
     * @param dest 拷贝到对象
     * @throws IllegalArgumentException if the arguments are incompatible
     */
    public static void shallowCopyFieldState(final Object src, final Object dest) throws IllegalArgumentException {
        if (src == null) {
            throw new IllegalArgumentException("Source for field copy cannot be null");
        }
        if (dest == null) {
            throw new IllegalArgumentException("Destination for field copy cannot be null");
        }
        if (!src.getClass().isAssignableFrom(dest.getClass())) {
            throw new IllegalArgumentException("Destination Class<?> [" + dest.getClass().getName() + "] must be same or subClass<?> as source Class<?> [" + src.getClass().getName() + "]");
        }

        doWithFields(src.getClass(), new FieldCallback() {
            
            public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
                makeAccessible(field);
                final Object srcValue = field.get(src);
                field.set(dest, srcValue);
            }
        }, copyableFields);
    }

    /**
     * Action to take on each method.
     */
    interface MethodCallback {
        /**
         * Perform an operation using the given method.
         * @param method the method to operate on
         * @throws IllegalArgumentException if the arguments are incompatible
         * @throws IllegalAccessException if the access is not allowed
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to method fields to be operated on by a method
     * callback.
     */
    interface MethodFilter {
        /**
         * Determine whether the given method matches.
         * @param method the method to check
         * @return 是否匹配
         */
        boolean matches(Method method);
    }

    /**
     * Callback interface invoked on each field in the hierarchy.
     */
    interface FieldCallback {
        /**
         * Perform an operation using the given field.
         * @param field the field to operate on
         * @throws IllegalArgumentException if the arguments are incompatible
         * @throws IllegalAccessException if the access is not allowed
         */
        void doWith(Field field) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to filter fields to be operated on by a field
     * callback.
     */
    interface FieldFilter {
        /**
         * Determine whether the given field matches.
         * @param field the field to check
         * @return 是否匹配
         */
        boolean matches(Field field);
    }

}
